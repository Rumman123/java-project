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

public class GenerateProfile {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(GenerateProfile.class, "/");

		try {
			Template template = cfg.getTemplate("profile.ftl");
			BufferedReader br = new BufferedReader(new InputStreamReader(GenerateProfile.class.getClassLoader().getResourceAsStream("profiles.csv")));
			String[] header = br.readLine().split(",");
			String line;
			for (int i = 0; (line = br.readLine()) != null; i++) {
				Map<String, Object> data = new HashMap<String, Object>();
				List<ValueHolder> systems = new ArrayList<ValueHolder>();
				data.put("title", "profile");
				data.put("exampleObject", new ValueHolder("properties", "value"));
				String[] profile = line.split(",");
				for (int j = 0; j < header.length; j++) {
					systems.add(new ValueHolder(header[j], profile[j]));
				}
				data.put("systems", systems);
				Writer out = new OutputStreamWriter(System.out);
				template.process(data, out);
				out.flush();
				Writer file = new FileWriter(new File("profile" + (i + 1) + ".html"));
				template.process(data, file);
				file.flush();
				file.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
