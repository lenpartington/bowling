package com.onepoint.game.domain.ball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.onepoint.game.exception.InvalidSequenceException;

public class SequenceBall implements Ball {

	int cursor = 0;
	private Pattern pattern_1 = Pattern.compile("^[0-9 -]{2}$");
	private Pattern pattern_2 = Pattern.compile("^[[0-9 -][/]]{2}$");
	private Pattern patternGlobal = Pattern.compile("^([0-9X-]{1}[0-9/-]*[ ]){9}([0-9X-][0-9/X-]*[ ]*){1,3}$");// ("^[0-9-/Xx]{12,21}$")

	private String sequence = "";

	public SequenceBall(String[] seq) throws InvalidSequenceException {
		if (validateSequence(seq)) {

			for (String s : seq) {
				sequence += s;
			}
			System.out.println("New sequence entered = " + sequence);
		} else {
			throw new InvalidSequenceException("Sequence invalid");
		}

	}

	@Override
	public int roll(int min, int max) throws InvalidSequenceException {
		int result = 0;

		String roll = sequence.split("")[cursor];

		switch (roll) {
		case "X":
			result = 10;
			break;
		case "-":
			result = 0;
			break;
		case "/":
			result = max;
			break;
		default:
			try {
				result = Integer.valueOf(roll);
			} catch (NumberFormatException e) {
				System.out.println("incorrect sequence " + roll);
				throw new InvalidSequenceException("incorrect sequence " + roll);
			}

		}
		cursor++;
		return result;
	}

	private boolean validateSequence(String[] args) throws InvalidSequenceException {
		globalValidation(args);
		// rollValidation(args);
		return true;
	}

	private void rollValidation(String[] args) throws InvalidSequenceException {

		for (String seq : args) {
			List<Matcher> matchers = new ArrayList();
			matchers.add(pattern_1.matcher(seq));
			matchers.add(pattern_2.matcher(seq));

			for (Matcher m : matchers) {
				if (!m.find()) {
					System.out.println("Error sequence validation pattern " + m.pattern() + ", seq= " + seq);
					throw new InvalidSequenceException("Sequence invalid : " + seq);
				}
			}
		}
	}

	private void globalValidation(String[] args) throws InvalidSequenceException {
		String seq = "";
		for (String s : args) {
			seq = seq + " " + s;
		}
		seq = seq.trim();
		// seq = seq.replace(" ", "");
		Matcher globalMatcher = patternGlobal.matcher(seq);
		if (!globalMatcher.find()) {
			System.out.println("global validation failed : seq= " + seq);
			throw new InvalidSequenceException("Sequence invalid");
		}
	}

}
