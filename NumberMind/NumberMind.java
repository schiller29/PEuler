import java.util.ArrayList;
import java.util.List;

public class NumberMind
{
	public static final byte TRUE = 1;
	public static final byte FALSE = -1;
	public static final byte UNKNOWN = 0;


	public static final int LINE_WIDTH = 16;

	public static final int[][] NUMBERS =
	{
		new int[] {5,6,1,6,1,8,5,6,5,0,5,1,8,2,9,3 },
		new int[] {3,8,4,7,4,3,9,6,4,7,2,9,3,0,4,7 },
		new int[] {5,8,5,5,4,6,2,9,4,0,8,1,0,5,8,7 },
		new int[] {9,7,4,2,8,5,5,5,0,7,0,6,8,3,5,3 },
		new int[] {4,2,9,6,8,4,9,6,4,3,6,0,7,5,4,3 },
		new int[] {3,1,7,4,2,4,8,4,3,9,4,6,5,8,5,8 },
		new int[] {4,5,1,3,5,5,9,0,9,4,1,4,6,1,1,7 },
		new int[] {7,8,9,0,9,7,1,5,4,8,9,0,8,0,6,7 },
		new int[] {8,1,5,7,3,5,6,3,4,4,1,1,8,4,8,3 },
		new int[] {2,6,1,5,2,5,0,7,4,4,3,8,6,8,9,9 },
		new int[] {8,6,9,0,0,9,5,8,5,1,5,2,6,2,5,4 },
		new int[] {6,3,7,5,7,1,1,9,1,5,0,7,7,0,5,0 },
		new int[] {6,9,1,3,8,5,9,1,7,3,1,2,1,3,6,0 },
		new int[] {6,4,4,2,8,8,9,0,5,5,0,4,2,7,6,8 },
		new int[] {2,3,2,1,3,8,6,1,0,4,3,0,3,8,4,5 },
		new int[] {2,3,2,6,5,0,9,4,7,1,2,7,1,4,4,8 },
		new int[] {5,2,5,1,5,8,3,3,7,9,6,4,4,3,2,2 },
		new int[] {1,7,4,8,2,7,0,4,7,6,7,5,8,2,7,6 },
		new int[] {4,8,9,5,7,2,2,6,5,2,1,9,0,3,0,6 },
		new int[] {3,0,4,1,6,3,1,1,1,7,2,2,4,6,3,5 },
		new int[] {1,8,4,1,2,3,6,4,5,4,3,2,4,5,8,9 },
		new int[] {2,6,5,9,8,6,2,6,3,7,3,1,6,8,6,7 }
	};

	public static final int[] CORRECT_NUMBERS =
	{
		2,
		1,
		3,
		3,
		3,
		1,
		2,
		3,
		1,
		2,
		3,
		1,
		1,
		2,
		0,
		2,
		2,
		3,
		1,
		3,
		3,
		2
	};


	public static void main(String[] args)
	{
		List<Line>[] filters = new List[NUMBERS.length];

		for (int i = 0; i < NUMBERS.length; i++)
		{
			filters[i] = makeFilterLines(NUMBERS[i], CORRECT_NUMBERS[i]);
		}

		Line currentPossibility = new Line();

		System.out.println(search(currentPossibility, filters, 0));
	}

	public static Line search(Line currentLine, List<Line>[] filters, int depth)
	{
		List<Line> depthFilters = filters[depth];

		for (Line depthFilter : depthFilters)
		{
			Line filteredLine = recombinePossibleWithFilter(currentLine, depthFilter);

			// The line has passed this filter.
			if (filteredLine != null)
			{
				if (depth == filters.length - 1)
				{
					// This has passed through all filters. Start passing it up.
					return filteredLine;
				}
				else
				{
					// Pass it down.
					filteredLine = search(filteredLine, filters, depth + 1);
					if (filteredLine != null)
					{
						// Passing the result up.
						return filteredLine;
					}
				}
			}
		}

		// None of the filters produced a viable result.
		return null;
	}


	public static Line recombinePossibleWithFilter(Line possible, Line filter)
	{
		if (possible.compatible(filter))
		{
			return possible.filter(filter);
		}
		else
		{
			return null;
		}
	}

	// Create lines with all the possible true/false/unknown assignment given the numbers and the
	// number of numbers that should be correct.
	public static List<Line> makeFilterLines(int[] numbers, int correctNumbers)
	{
		List<Line> currentList = new ArrayList<Line>();
		List<Line> nextList = new ArrayList<Line>();

		// Set up the initial line, where all numbers are assumed to be false.
		Line line = new Line();
		for (int i = 0; i < LINE_WIDTH; i++)
		{
			line.digits[i].correct[numbers[i]] = FALSE;
		}
		currentList.add(line);

		for (int n = 0; n < correctNumbers; n++)
		{
			for (Line l : currentList)
			{
				nextList.addAll(addTrueToLine(l));
			}

			List<Line> tempL = currentList;
			currentList = nextList;
			nextList = tempL;
			nextList.clear();
		}

		return currentList;
	}

	public static List<Line> addTrueToLine(Line line)
	{
		List<Line> list = new ArrayList<Line>();
		// First, find the final TRUE already in.
		int lastTrue = -1;
		for (int i = 0; i < LINE_WIDTH; i++)
		{
			if (line.digits[i].hasTrue())
			{
				lastTrue = i;
			}
		}

		for (int i = lastTrue + 1; i < LINE_WIDTH; i++)
		{
			Line l = line.clone();
			l.digits[i].makeSingleFalseTrue();
			list.add(l);
		}

		return list;
	}

	public static class Line
	{
		public Digit[] digits = new Digit[LINE_WIDTH];

		public Line()
		{
			for (int i = 0; i < digits.length; i++)
			{
				digits[i] = new Digit();
			}
		}

		public String toString()
		{
			String s = "";
			for (Digit d : digits)
			{
				s += d + "\n";
			}

			return s;
		}

		public Line clone()
		{
			Line l = new Line();

			for (int i = 0; i < LINE_WIDTH; i++)
			{
				l.digits[i] = digits[i].clone();
			}

			return l;
		}

		public boolean compatible(Line filter)
		{
			for (int i = 0; i < LINE_WIDTH; i++)
			{
				if (!digits[i].compatible(filter.digits[i]))
				{
					return false;
				}
			}

			return true;
		}

		public Line filter(Line filter)
		{
			Line newLine = this.clone();

			for (int i = 0; i < LINE_WIDTH; i++)
			{
				newLine.digits[i].filter(filter.digits[i]);
			}

			return newLine;
		}
	}

	public static class Digit
	{
		public byte[] correct = new byte[10];

		public String toString()
		{
			for (int i = 0; i < 10; i++)
			{
				if (correct[i] == TRUE)
				{
					return "" + i;
				}
			}

			String s = "";
			for (int i = 0; i < 10; i++)
			{
				if (correct[i] == UNKNOWN)
				{
					s += i;
				}
			}

			return s.length() > 0 ? s : "X";
		}

		public boolean hasTrue()
		{
			for (byte c : correct)
			{
				if (c == TRUE)
				{
					return true;
				}
			}

			return false;
		}

		public void makeSingleFalseTrue()
		{
			int falseIndex = -1;
			for (int i = 0; i < 10; i++)
			{
				if (correct[i] == FALSE)
				{
					falseIndex = i;
					break;
				}
			}

			for (int i = 0; i < 10; i++)
			{
				correct[i] = FALSE;
			}

			correct[falseIndex] = TRUE;
		}

		public boolean compatible(Digit otherDigit)
		{
			for (int i = 0; i < 10; i++)
			{
				if (correct[i] == TRUE && otherDigit.correct[i] == FALSE)
				{
					return false;
				}

				if (correct[i] == FALSE && otherDigit.correct[i] == TRUE)
				{
					return false;
				}
			}

			return true;
		}

		public void filter(Digit otherDigit)
		{
			for (int i = 0; i < 10; i++)
			{
				if (correct[i] == UNKNOWN)
				{
					correct[i] = otherDigit.correct[i];
				}
			}
		}

		public Digit clone()
		{
			Digit d = new Digit();
			for (int i = 0; i < 10; i++)
			{
				d.correct[i] = correct[i];
			}

			return d;
		}
	}
}
