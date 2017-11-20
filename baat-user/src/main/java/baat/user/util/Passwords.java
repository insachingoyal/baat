package baat.user.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

/**
 * A utility class to hash passwords and check passwords vs hashed values. It uses a combination of hashing and unique
 * salt. The algorithm used is PBKDF2WithHmacSHA1 which, although not the best for hashing password (vs. bcrypt) is
 * still considered robust and <a href="https://security.stackexchange.com/a/6415/12614"> recommended by NIST </a>.
 * The hashed value has 256 bits.
 */
public class Passwords {

	private static final String CHARSET = "UTF-8";
	private static final Random RANDOM = new SecureRandom();
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;

	/**
	 * static utility class
	 */
	private Passwords() {
	}

	/**
	 * Returns a random salt to be used to hash a password.
	 *
	 * @return a 16 bytes random salt
	 */
	public static String getNextSalt() {
		try {
			byte[] salt = new byte[16];
			RANDOM.nextBytes(salt);
			return new String(salt, CHARSET);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Error while generating salt: " + e.getMessage(), e);
		}
	}

	/**
	 * Returns a salted and hashed password using the provided hash.<br>
	 * Note - side effect: the password is destroyed (the char[] is filled with zeros)
	 *
	 * @param password the password to be hashed
	 * @param salt     a 16 bytes salt, ideally obtained with the getNextSalt method
	 * @return the hashed password with a pinch of salt
	 */
	public static String hash(final String password, final String salt) {
		PBEKeySpec spec = null;
		try {
			spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(CHARSET), ITERATIONS, KEY_LENGTH);
			Arrays.fill(password.toCharArray(), Character.MIN_VALUE);
			final SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return new String(skf.generateSecret(spec).getEncoded(), CHARSET);
		} catch (final NoSuchAlgorithmException | InvalidKeySpecException | UnsupportedEncodingException e) {
			throw new RuntimeException("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			if (spec != null) {
				spec.clearPassword();
			}
		}
	}

	/**
	 * Returns true if the given password and salt match the hashed value, false otherwise.<br>
	 * Note - side effect: the password is destroyed (the char[] is filled with zeros)
	 *
	 * @param password     the password to check
	 * @param salt         the salt used to hash the password
	 * @param expectedHash the expected hashed value of the password
	 * @return true if the given password and salt match the hashed value, false otherwise
	 */
	public static boolean isExpectedPassword(final String password, final String salt, final String expectedHash) {
		try {
			String pwdHash = hash(password, salt);
			byte[] pwdHashBytes = pwdHash.getBytes(CHARSET);
			byte[] expectedHashBytes = expectedHash.getBytes(CHARSET);
			Arrays.fill(password.toCharArray(), Character.MIN_VALUE);
			if (pwdHashBytes.length != expectedHashBytes.length)
				return false;
			for (int i = 0; i < pwdHashBytes.length; i++) {
				if (pwdHashBytes[i] != expectedHashBytes[i])
					return false;
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Error while checking password hash: " + e.getMessage(), e);
		}
		return true;
	}

	/**
	 * Generates a random password of a given length, using letters and digits.
	 *
	 * @param length the length of the password
	 * @return a random password
	 */
	public static String generateRandomPassword(final int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int c = RANDOM.nextInt(62);
			if (c <= 9) {
				sb.append(String.valueOf(c));
			} else if (c < 36) {
				sb.append((char) ('a' + c - 10));
			} else {
				sb.append((char) ('A' + c - 36));
			}
		}
		return sb.toString();
	}
}
