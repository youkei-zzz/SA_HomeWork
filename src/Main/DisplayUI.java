package Main;

import ClassicModel.Main;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class DisplayUI {
	public static void main(String[] args){
		JFrame frame = new JFrame("经典软件体系结构");
		frame.setSize(1300, 700);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JTabbedPane tab = new JTabbedPane();
		//分别设置四种panel的样式，大同小异，可以通过同一个模板产生
		tab.add("主/子程序模式",createPanel(1));
		tab.add("面向对象模式",createPanel(2));
		tab.add("观察者模式",createPanel(3));
		tab.add("管道模式",createPanel(4));
		tab.setSelectedIndex(0);

		frame.setVisible(true);
		frame.setContentPane(tab);
	}
	private static JComponent createPanel(int type) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		String content_desc;
		String content_imgurl;
		String content_code;
		if(type == 1) {
			content_desc = """
					主程序/子程序风格将系统组织成层次结构，
					包括一个主程序和一系列子程序，
					主要用于能够将系统功能依层次分解为多个顺序执行步骤的系统。""";
			content_imgurl = "images/1.jpg";
			content_code = """
					核心代码:\r
					public static void main(String[] args) {\r
					        demo1 kwic = new demo1();\r
					        kwic.input("src/input.txt");\r
					        kwic.shift();\r
					        kwic.alphabetizer();\r
					        kwic.output("src/output.txt");\r
					    }""";
		}
		else if(type == 2) {
			content_desc = """
					面向对象式风格将系统组织为多个独立的对象，
					每个对象封装其内部的数据，
					并基于数据对外提供服务，
					适用于那些能够基于数据信息分解和组织的软件系统。""";
			content_imgurl = "images/2.png";
			content_code = """
					核心代码:\r
					public static void main(String[] args) {\r
					        Input input = new Input();\r
					        input.input("src/input.txt");\r
					        Shift shift = new Shift(input.getLineTxt());\r
					        shift.shift();\r
					        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r
					        alphabetizer.sort();\r
					        Output output = new Output(alphabetizer.getKwicList());\r
					        output.output("src/output.txt");\r
					    }""";
		}
		else if(type == 3) {
			content_desc = """
					观察者模式定义了一种一对多的依赖关系，
					让多个观察者对象同时监听某一个主题对象。
					这个主题对象在状态变化时，
					会通知所有的观察者对象，
					使他们能够自动更新自己。
					它可以实现表示层和数据逻辑层的分离。""";
			content_imgurl = "images/3.jpg";
			content_code = """
					核心代码:\r
					public static void main(String[] args) {\r
					       
					        KWICSubject kwicSubject = new KWICSubject();\r
					        Input input = new Input("src/input.txt");\r
					        Shift shift = new Shift(input.getLineTxt());\r
					        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r
					        Output output = new Output(alphabetizer.getKwicList(), "src/output.txt");\r
					\r
					        kwicSubject.addObserver(input);\r
					        kwicSubject.addObserver(shift);\r
					        kwicSubject.addObserver(alphabetizer);\r
					        kwicSubject.addObserver(output);\r
					        kwicSubject.startKWIC();\r
					    }""";
		}
		else if(type == 4) {
			content_desc = """
					管道-过滤器模式结构就像是一条产品加工流水线，
					原材料在流水线上经过一个个工人的加工，
					最终生产出产品。
					适用于很容易地被分解成一组离散的、独立的步骤的软件。""";
			content_imgurl = "images/4.png";
			content_code = """
					核心代码:\r
					public static void main(String[] args) throws IOException {\r
					        File inFile = new File("src/input.txt");\r
					        File outFile = new File("src/output.txt");\r
					        Pipe pipe1 = new Pipe();\r
					        Pipe pipe2 = new Pipe();\r
					        Pipe pipe3 = new Pipe();\r
					        Input input = new Input(inFile, pipe1);\r
					        Shift shift = new Shift(pipe1, pipe2);\r
					        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);\r
					        Output output = new Output(outFile,pipe3);\r
					        input.transform();\r
					        shift.transform();\r
					        alphabetizer.transform();\r
					        output.transform();\r
					    }""";
		}
		else {
			return null;
		}
		JTextArea desc = new JTextArea(content_desc);
		JScrollPane scroll_desc = new JScrollPane(desc);
		scroll_desc.setFont(new Font(null, Font.PLAIN, 80));
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.weightx = 0.1;
		gridBagConstraints_1.weighty = 0.2;
		gridBagConstraints_1.gridy = 0;
		gridBagConstraints_1.gridx = 0;
		panel.add(scroll_desc,gridBagConstraints_1);
		
		
		ImageIcon img = new ImageIcon(content_imgurl);
		img.setImage(img.getImage().getScaledInstance(450, 330, 0));
		JLabel label = new JLabel(img);
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.weightx = 0.3;
		gridBagConstraints_2.weighty = 0.5;
		gridBagConstraints_2.gridy = 0;
		gridBagConstraints_2.gridx = 1;

		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		panel.add(label,gridBagConstraints_2);
		
		JTextArea result = new JTextArea("运行结果");
		JScrollPane scroll_result = new JScrollPane(result);
		scroll_result.setFont(new Font(null, Font.PLAIN, 20));
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy = 0;//行
		gridBagConstraints_5.gridx = 2;//列
		gridBagConstraints_5.gridheight = 2;
		gridBagConstraints_5.weightx = 0.4;
		gridBagConstraints_5.weighty = 1;
		gridBagConstraints_5.fill = GridBagConstraints.BOTH;
		panel.add(scroll_result,gridBagConstraints_5);
		
		JTextArea code = new JTextArea(content_code);
		JScrollPane scroll_code = new JScrollPane(code);
		scroll_result.setFont(new Font(null, Font.PLAIN, 10));
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 1;//行
		gridBagConstraints_3.gridx = 0;//列
		gridBagConstraints_3.weightx = 0.5;
		gridBagConstraints_3.weighty = 0.5;
		gridBagConstraints_3.fill = GridBagConstraints.BOTH;
		panel.add(scroll_code,gridBagConstraints_3);
		
		JButton button = new JButton("运行");
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		button.setFont(new Font(null, Font.TRUETYPE_FONT, 30));
		button.setForeground(Color.GREEN);
		button.setBackground(Color.BLUE);
		gridBagConstraints_4.gridy = 1;
		gridBagConstraints_4.gridx = 1;
		gridBagConstraints_4.weightx = 0.1;
		gridBagConstraints_4.weighty = 0.5;
		gridBagConstraints_4.ipadx = 30;
		gridBagConstraints_4.ipady = 40;
		panel.add(button,gridBagConstraints_4);

		if(type == 1) {
			button.addActionListener(e -> {
				try {
					//运行
					result.setText("运行结果：");
					clearFile();
					Main.main(null);
					String result_content = getFileContent();
					result.append(result_content);
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		}
		else if(type == 2) {
			button.addActionListener(e -> {
				try {
					result.setText("运行结果：");
					clearFile();
					OOPModel.Main.main(null);
					String result_content = getFileContent();
					result.append(result_content);
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		}
		else if(type == 3) {
			button.addActionListener(e -> {
				try {
					result.setText("运行结果：");
					clearFile();
					ObserverModel.Main.main(null);
					String result_content = getFileContent();
					result.append(result_content);
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		}
		else {
			button.addActionListener(e -> {
				try {

					result.setText("运行结果：");
					clearFile();
					PipeModel.Main.main(null);
					String result_content = getFileContent();
					result.append(result_content);
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		}
		
		return panel;
	}
	public static String getFileContent(){
		File file = new File("src/output.txt");
	    StringBuilder result = new StringBuilder();
	    try{
	      BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
	      String res;
	      while((res = bufferedreader.readLine())!=null){
	        result.append(System.lineSeparator()).append(res);
	      }
	      bufferedreader.close();  
	    }catch(Exception e){
	      e.printStackTrace();
	    }
	    return result.toString();
	  }
	public static void clearFile(){
		File file = new File("src/output.txt");
		FileWriter filewriter;
		try {
			filewriter = new FileWriter (file);
			filewriter.write("");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
