package org.sharpsw.tools.tsc;

import java.io.IOException;
import java.util.List;

public class TransactionSetDeltaGen {
	public static void main(String[] args) {
		if(args.length < 3) {
			System.err.println("Usage: java org.sharpsw.tools.tsc.TransactionSetDeltaGen <file1> <file2> <result_file>");
			System.exit(1);
		}
		
		try {
			StringBuffer log = new StringBuffer();
			log.append("Processing file '").append(args[0]).append("'");
			System.out.println(log.toString());
			TransactionSetFactory factory = new TransactionSetFactory();
			List<Long> base = factory.parse(args[0]);			
			StringBuilder log1 = new StringBuilder();
			log1.append("File '").append(args[0]).append("' contains ").append(base.size()).append(" transactions");
			System.out.println(log1.toString());
			
			StringBuffer log2 = new StringBuffer();
			log2.append("Processing file '").append(args[1]).append("'");
			System.out.println(log2.toString());
			List<Long> reference = factory.parse(args[1]);			
			StringBuilder log3 = new StringBuilder();
			log3.append("File '").append(args[1]).append("' contains ").append(reference.size()).append(" transactions");
			System.out.println(log3.toString());
			
			TransactionListDiffUtil util = new TransactionListDiffUtil();
			List<Long> result = util.generateDeltaList(base, reference);
			StringBuilder log4 = new StringBuilder();
			log4.append("File '").append(args[2]).append("' contains ").append(result.size()).append(" transactions");
			System.out.println(log4.toString());
			
			System.out.println("Iniciando comparação do conjunto de ids de transação");
			DataFileExport export = new DataFileExport();
			export.exportData(result, args[2]);
			
			System.out.println("Concluído.");
		} catch (IOException exception) {
			StringBuffer message = new StringBuffer();
			message.append("Erro ao processa arquivos: ").append(exception.getMessage());
			System.err.println(message.toString());
			exception.printStackTrace();
			System.exit(2);
		}
	}

}
