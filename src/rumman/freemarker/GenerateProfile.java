package rumman.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
					
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("title", "profile");
			data.put("exampleObject", new ValueHolder("properties",
					"value"));

			List<ValueHolder> systems = new ArrayList<ValueHolder>();
			systems.add(new ValueHolder("Name", "Rumman Khan"));
			systems.add(new ValueHolder("Date of Birth", "22/12/1992"));
			systems.add(new ValueHolder("Nationality", "Indian"));
			systems.add(new ValueHolder("Gender", "Male"));
			systems.add(new ValueHolder("Marital Status", "Single"));
			systems.add(new ValueHolder("Languages", "English,Hindi,Urdu"));
			systems.add(new ValueHolder("Hobbies", "Playing Cricket,Photography"));
			systems.add(new ValueHolder("Address", "26,elgine road,Sitapur"));
			systems.add(new ValueHolder("E:Mail", "khanrumman.khan@gmail.com"));
			systems.add(new ValueHolder("Date", "09/09/2014"));
			data.put("systems", systems);

			Map<String, Object> data2 = new HashMap<String, Object>();
			data2.put("title", "profile2");
			data2.put("exampleObject", new ValueHolder("properties",
					"value"));

			List<ValueHolder> systems2 = new ArrayList<ValueHolder>();
			systems2.add(new ValueHolder("birthcity", "mumbai"));
			systems2.add(new ValueHolder("name", "Akshay"));
			systems2.add(new ValueHolder("qualification", "B.tech"));
			systems2.add(new ValueHolder("branch", "CSE"));
			data2.put("systems", systems2);

			Writer out = new OutputStreamWriter(System.out);
			template.process(data, out);
			template.process(data2, out);
			out.flush();

			Writer file1 = new FileWriter(new File("profile1.html"));
			Writer file2 = new FileWriter(new File("profile2.html"));

			template.process(data, file1);
			template.process(data2, file2);
			file1.flush();
			file1.close();
			file2.flush();
			file2.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
