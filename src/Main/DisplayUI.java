package Main;

import ClassicModel.Main;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class DisplayUI {
	public static void main(String[] args){
		JFrame frame = new JFrame("���������ϵ�ṹ");
		frame.setSize(1300, 700);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JTabbedPane tab = new JTabbedPane();
		//�ֱ���������panel����ʽ����ͬС�죬����ͨ��ͬһ��ģ�����
		tab.add("��/�ӳ���ģʽ",createPanel(1));
		tab.add("�������ģʽ",createPanel(2));
		tab.add("�۲���ģʽ",createPanel(3));
		tab.add("�ܵ�ģʽ",createPanel(4));
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
					������/�ӳ�����ϵͳ��֯�ɲ�νṹ��
					����һ���������һϵ���ӳ���
					��Ҫ�����ܹ���ϵͳ��������ηֽ�Ϊ���˳��ִ�в����ϵͳ��""";
			content_imgurl = "images/1.jpg";
			content_code = """
					���Ĵ���:\r
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
					�������ʽ���ϵͳ��֯Ϊ��������Ķ���
					ÿ�������װ���ڲ������ݣ�
					���������ݶ����ṩ����
					��������Щ�ܹ�����������Ϣ�ֽ����֯�����ϵͳ��""";
			content_imgurl = "images/2.png";
			content_code = """
					���Ĵ���:\r
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
					�۲���ģʽ������һ��һ�Զ��������ϵ��
					�ö���۲��߶���ͬʱ����ĳһ���������
					������������״̬�仯ʱ��
					��֪ͨ���еĹ۲��߶���
					ʹ�����ܹ��Զ������Լ���
					������ʵ�ֱ�ʾ��������߼���ķ��롣""";
			content_imgurl = "images/3.jpg";
			content_code = """
					���Ĵ���:\r
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
					�ܵ�-������ģʽ�ṹ������һ����Ʒ�ӹ���ˮ�ߣ�
					ԭ��������ˮ���Ͼ���һ�������˵ļӹ���
					������������Ʒ��
					�����ں����׵ر��ֽ��һ����ɢ�ġ������Ĳ���������""";
			content_imgurl = "images/4.png";
			content_code = """
					���Ĵ���:\r
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
		
		JTextArea result = new JTextArea("���н��");
		JScrollPane scroll_result = new JScrollPane(result);
		scroll_result.setFont(new Font(null, Font.PLAIN, 20));
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy = 0;//��
		gridBagConstraints_5.gridx = 2;//��
		gridBagConstraints_5.gridheight = 2;
		gridBagConstraints_5.weightx = 0.4;
		gridBagConstraints_5.weighty = 1;
		gridBagConstraints_5.fill = GridBagConstraints.BOTH;
		panel.add(scroll_result,gridBagConstraints_5);
		
		JTextArea code = new JTextArea(content_code);
		JScrollPane scroll_code = new JScrollPane(code);
		scroll_result.setFont(new Font(null, Font.PLAIN, 10));
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 1;//��
		gridBagConstraints_3.gridx = 0;//��
		gridBagConstraints_3.weightx = 0.5;
		gridBagConstraints_3.weighty = 0.5;
		gridBagConstraints_3.fill = GridBagConstraints.BOTH;
		panel.add(scroll_code,gridBagConstraints_3);
		
		JButton button = new JButton("����");
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
					//����
					result.setText("���н����");
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
					result.setText("���н����");
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
					result.setText("���н����");
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

					result.setText("���н����");
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
