package A07_BubbleSort;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen)
	{
		for (int j = 0; j<personen.length-1; ++j)
		{
			for (int i = 0; i<personen.length-1-j; ++i)
			{
				if (personen[i].compareTo(personen[i+1]) > 0)
				{
					bubble(personen, i);
				}
			}
		}
	}

	private void bubble(Person[] personen, int index)
	{
		Person temp = personen[index+1];
		personen[index+1] = personen[index];
		personen[index] = temp;
	}
	
}
