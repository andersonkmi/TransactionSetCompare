package org.sharpsw.tools.tsc;

import java.util.ArrayList;
import java.util.List;

public class TransactionListDiffUtil {
	public List<Long> generateDeltaList(List<Long> base, List<Long> reference) {
		List<Long> elements = new ArrayList<Long>(base);
		elements.removeAll(reference);			
		return elements;
	}
}
