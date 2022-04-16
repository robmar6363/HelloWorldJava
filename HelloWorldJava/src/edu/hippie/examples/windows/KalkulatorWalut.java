package edu.hippie.examples.windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


/**
 * Example of Currency Calculator written in polish.
 * Gets numbers from Github - this can be replaced with local file.
 * @author Robert Marciniak
 *
 */
public class KalkulatorWalut extends JFrame {

	String[] waluty = { "Euro", "PLN", "USD" };
	JLabel [] label = {new JLabel("Kwota "),
			new JLabel("Przelicz z"),
			new JLabel("Przelicz na"),
			new JLabel(""),
			new JLabel("Wynik")};
	JTextField kwota= new JTextField(10);
	JComboBox<String> walutaPierwotna= new JComboBox<String>(waluty);
	JComboBox<String> walutaDocelowa= new JComboBox<String>(waluty);
	JButton oblicz= new JButton("Oblicz");
	JTextPane result = new JTextPane();
	Double [] kursy=new Double[2];
	
	
	private void init(){
		 Scanner s = null;
		 
	        try {
	        	URL numbers = new URL("https://raw.githubusercontent.com/robmar6363/HelloWorldJava/main/HelloWorldJava/src/edu/hippie/examples/windows/currencies.txt"); // get data
	            s = new Scanner(
	                    new BufferedReader(new InputStreamReader(numbers.openStream())));
	            s.useLocale(Locale.US);
	           int i=0;
	           while (s.hasNextLine()) {
	        	   if (s.hasNextDouble()) {
                       kursy[i]= s.nextDouble();
                       i++;
                   } else {
                       s.next();
                   }   
	                  
	            }
	        } catch (IOException e) {
				
				e.printStackTrace();
			} finally {
	            s.close();
	        }
		}
	
	
	class Go implements ActionListener {
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			Double rezultat=Double.parseDouble(kwota.getText());
			String waluta1 = (String)walutaPierwotna.getSelectedItem();
			String waluta2 = (String)walutaDocelowa.getSelectedItem();

				
			if(waluta1.equals("Euro")&&waluta2.equals("PLN")) 
				rezultat =Double.parseDouble(kwota.getText())*kursy[0];
			if(waluta1.equals("PLN")&&waluta2.equals("Euro")) 
				rezultat =Double.parseDouble(kwota.getText())/kursy[0];	
			
			if(waluta1.equals("USD")&&waluta2.equals("PLN")) 
				rezultat =Double.parseDouble(kwota.getText())*kursy[1];
			
			if(waluta1.equals("PLN")&&waluta2.equals("USD")) 
				rezultat =Double.parseDouble(kwota.getText())/kursy[1];
			
			if(waluta1.equals("Euro")&&waluta2.equals("USD")) 
				rezultat =Double.parseDouble(kwota.getText())*kursy[0]/kursy[1];
			
			if(waluta1.equals("USD")&&waluta2.equals("Euro")) 
				rezultat =Double.parseDouble(kwota.getText())*kursy[1]/kursy[0];
			
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMaximumFractionDigits(2);			
			 result.setText(nf.format(rezultat));
			

			}
	};
	
	public KalkulatorWalut()  {
		init();
		this.setTitle("Kalkulator walut");
		walutaPierwotna.setSelectedIndex(0);
		walutaDocelowa.setSelectedIndex(1);
		oblicz.addActionListener(new Go());
		setLayout(new GridLayout(5,1));
		add(label[0]);
		add(kwota);
		add(label[1]);
		add(walutaPierwotna);
		add(label[2]);
		add(walutaDocelowa);
		add(label[3]);
		add(oblicz);
		add(label[4]);
		result.setEditable(false);
		add(result);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	new KalkulatorWalut();
	}

}

