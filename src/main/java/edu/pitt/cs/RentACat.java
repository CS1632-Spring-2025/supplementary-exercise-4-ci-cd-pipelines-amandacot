package edu.pitt.cs;

import org.mockito.Mockito;
import static org.mockito.Mockito.*; 

public interface RentACat {
	public static RentACat createInstance(InstanceType type) {
		switch (type) {
			case IMPL:
				return new RentACatImpl();
			case BUGGY:
				return new RentACatBuggy();
			case SOLUTION:
				return new RentACatSolution();
			case MOCK:
				// TODO: Return a mock object that emulates the behavior of the real object, if you feel you need one.
				 // Creating a mock RentACat object
                		RentACat mockRentACat = mock(RentACat.class);

                		// Mocking the behavior of returnCat()
                		when(mockRentACat.returnCat(anyInt())).thenAnswer(invocation -> {
                    			int id = invocation.getArgument(0);
                    			System.out.println("Mock: Returning cat with ID " + id);
                    			return true; // Simulates a successful return
                		});

                		// Mocking the behavior of rentCat()
               			when(mockRentACat.rentCat(anyInt())).thenAnswer(invocation -> {
                    			int id = invocation.getArgument(0);
                    			System.out.println("Mock: Renting cat with ID " + id);
                    			return true; // Simulates a successful rent
               			});

                		// Mocking the behavior of renameCat()
                		when(mockRentACat.renameCat(anyInt(), anyString())).thenAnswer(invocation -> {
                    			int id = invocation.getArgument(0);
                    			String name = invocation.getArgument(1);
                    			System.out.println("Mock: Renaming cat with ID " + id + " to " + name);
                    			return true; // Simulates a successful rename
               		 	});

                		// Mocking the behavior of listCats()
                		when(mockRentACat.listCats()).thenReturn("Mock: ID 1. MockCat1\nMock: ID 2. MockCat2");

               	 		// Mocking the behavior of addCat()
                		doAnswer(invocation -> {
                    			Cat cat = invocation.getArgument(0);
                    			System.out.println("Mock: Adding cat " + cat.getName());
                    			return null; // No return value for void method
                			}).when(mockRentACat).addCat(any(Cat.class));

                		return mockRentACat;
					default:
					assert (false);
					return null;
			}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.

	public boolean returnCat(int id);

	public boolean rentCat(int id);

	public boolean renameCat(int id, String name);

	public String listCats();

	public void addCat(Cat c);
}
