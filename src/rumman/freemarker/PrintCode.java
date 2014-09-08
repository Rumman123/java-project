package rumman.freemarker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class PrintCode {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(PrintCode.class, "/");

		try {
			Template template = cfg.getTemplate("code.ftl");
			BufferedReader br = new BufferedReader(new InputStreamReader(PrintCode.class.getClassLoader().getResourceAsStream("codes.csv")));
			String[] header = br.readLine().split(";");
			String line;
			for (int i = 0; (line = br.readLine()) != null; i++) {
				Map<String, Object> data = new HashMap<String, Object>();
				List<ValueHolder> statements = new ArrayList<ValueHolder>();
				data.put("title", "Responsive Layout Example");
				String[] content=line.split(";");
				for (int j = 0; j < header.length && j < content.length; j++) {
					statements.add(new ValueHolder(header[j], content[j]));
				}
				data.put("statements", statements);
	
			Writer out = new OutputStreamWriter(System.out);
			template.process(data, out);
			out.flush();
			
			Writer file = new FileWriter(new File("content.html"));
			template.process(data, file);
			file.flush();
			file.close();
			}
	} 
	catch (IOException e) {
		e.printStackTrace();
	} catch (TemplateException e) {
		e.printStackTrace();
	}

}
			
}
