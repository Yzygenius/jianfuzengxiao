package com.jianfuzengxiao.job.codegenerator;

import java.util.List;

/**
 * 运行生成的main
 *
 */
public class DoMain {

	public static void main(String[] args) {
		try {
			CodeGenerator entityCreater = new CodeGenerator();
			List<String> tables = entityCreater.getTables();
			for (String table : tables) {
				if("dual".equals(table)){
					
				}else{
					entityCreater.createEntityClass(table);
					entityCreater.createDaoClass(table);
					entityCreater.createDaoImplClass(table);
					entityCreater.createServiceClass(table);
					entityCreater.createServiceImplClass(table);
					entityCreater.createControllerClass(table);
//					entityCreater.createJspView(table);
					
				}
			}
			entityCreater.createTableClass(tables);
			System.out.println("ok!!!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
