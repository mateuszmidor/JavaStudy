package com.mateuszmidor;

import java.util.ArrayList;
import java.util.Collection;

public class GenericCopier {
	
	// do kolekcji typu T skopiuj elementy typu T lub jego pochodne i zwróæ typ T
	public <T> T makeCopyMoreStrict(Collection<? extends T> from, Collection<T> to) {

		T last = null;
		for (T element : from) {
			last = element;
			to.add(last);
		}

		return last;
	}
	
	// skopiuj elementy typu T do kolekcji typu T lub jego rodzica (np do kolekcji Object'ow)
	public <T> T makeCopyMoreFlexible(Collection<T> from, Collection<? super T> to) {
		
		T last = null;
		for (T element : from) {
			last = element;
			to.add(last);
		}

		return last;
	}

	@SuppressWarnings("unused")
	public GenericCopier() {
		System.out.println("Generyczna kopiarka kolekcji rusza!");

		Collection<String> from = new ArrayList<String>();
		Collection<Object> to = new ArrayList<Object>();
		
		Object out1 = makeCopyMoreStrict(from, to);
		Object out2 = makeCopyMoreFlexible(from, to);
		
		//String out3 =  makeCopyMoreStrict(from, to); // nie da siê bo zwraca Object!!!
		String out4 = makeCopyMoreFlexible(from, to);
		
		System.out.println();
	}
}
