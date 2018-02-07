//import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Observer;
import java.util.Observable;

/**
 * This View class observes Model and creates a basic GUI for users to interact with.
 */
public class View extends JPanel implements Observer {
	
	private Model model;
	private GridBagLayout layout;
	private GridBagConstraints c;
	private JTextArea display;
	private JTextField signature;
	private JButton btn1;
	private JButton[] btnSig;
	private JButton btnStar;
	private JButton btn0;
	private JButton btnHash;
	//private JList<String> prefixes;
	
	/**
	 * Constructor
	 * 
	 * @param model model to observe
	 */
	public View (Model model) {
		super();
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.model = model;
		this.model.addObserver(this);
		this.btnSig = new JButton[8];
		
		this.setupLayout();
		this.setupDisplay();
		this.setupSignatureDisplay();
		this.setupButtons();
		//this.setupPrefixesList();
	}
	
	/**
	 * Getter for the model
	 * 
	 * @return model
	 */
	public Model getModel () {
		return this.model;
	}
	
	/**
	 * Sets up the layout of the GUI
	 */
	public void setupLayout () {
		this.layout = new GridBagLayout();
		this.c = new GridBagConstraints();
		this.c.fill = GridBagConstraints.BOTH;
		this.setLayout(this.layout);
	}
	
	/**
	 * Sets up the text display
	 */
	public void setupDisplay () {
		this.display = new JTextArea(8, 22);
		//this.display.setText("|"); // temporary solution to having a caret
		this.display.setEditable(false);
		this.display.setLineWrap(true);
		
		this.layoutDisplay();
	}
	/**
	 * Layout the text display
	 */
	public void layoutDisplay () {
		this.c.gridx = 0;
		this.c.gridy = 0;
		this.c.gridwidth = 3;
		this.c.gridheight = 4;
		this.add(this.display, this.c);
	}
	
	/**
	 * Sets up the signature display
	 */
	public void setupSignatureDisplay () {
		this.signature = new JTextField("");
		this.signature.setEditable(false);
		this.signature.setHorizontalAlignment(JTextField.CENTER);
		
		this.layoutSignatureDisplay();
	}
	/**
	 * Layout the signature display
	 */
	public void layoutSignatureDisplay () {
		this.c.gridy = 4;
		this.c.gridheight = 1;
		this.add(this.signature, this.c);
	}
	
	/**
	 * Sets up the buttons
	 */
	public void setupButtons () {
		this.btn1 = new JButton("<html><center>1<br />&nbsp;</center></html>");
		this.btnSig[0] = new JButton("<html><center>2<br />abc</center></html>");
		this.btnSig[1] = new JButton("<html><center>3<br />def</center></html>");
		this.btnSig[2] = new JButton("<html><center>4<br />ghi</center></html>");
		this.btnSig[3] = new JButton("<html><center>5<br />jkl</center></html>");
		this.btnSig[4] = new JButton("<html><center>6<br />mno</center></html>");
		this.btnSig[5] = new JButton("<html><center>7<br />pqrs</center></html>");
		this.btnSig[6] = new JButton("<html><center>8<br />tuv</center></html>");
		this.btnSig[7] = new JButton("<html><center>9<br />wxyz</center></html>");
		this.btnStar = new JButton("<html><center>*<br />&nbsp;</center></html>");
		this.btn0 = new JButton("<html><center>0<br />&nbsp;</center></html>");
		this.btnHash = new JButton("<html><center>#<br />&nbsp;</center></html>");
		
		this.layoutButtons();
		this.listenToButtons();
	}
	/**
	 * Layout the buttons
	 */
	public void layoutButtons () {
		this.c.gridy = 5;
		this.c.gridwidth = 1;
		this.c.weightx = 0.33;
		this.add(this.btn1, this.c);
		for (int i = 0; i < 8; i++) {
			this.c.gridx = (i + 4) % 3;
			this.c.gridy = ((i + 4) / 3) + 4;
			this.add(this.btnSig[i], this.c);
		}
		this.c.gridx = 0;
		this.c.gridy = 8;
		this.add(this.btnStar, this.c);
		this.c.gridx = 1;
		this.add(this.btn0, this.c);
		this.c.gridx = 2;
		this.add(this.btnHash, this.c);
	}
	/**
	 * Add listeners to the buttons
	 */
	public void listenToButtons () {
		for (int i = 0; i < 8; i++) {
			final int ii = i; // so we can use i inside the inner class
			this.btnSig[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed (ActionEvent e) {
					getModel().updateSignature(ii + 2);
				}
			});
		}
		this.btnStar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				getModel().cyclePrefixSelection();
			}
		});
		this.btn0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				getModel().insertWord();
			}
		});
		this.btnHash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				getModel().removeLastSignature();
			}
		});
	}
	
//	/**
//	 * Sets up the 
//	 */
//	public void setupPrefixesList () {
//		this.prefixes = new JList<String>();
//		this.prefixes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		this.prefixes.setLayoutOrientation(JList.VERTICAL);
//		
//		this.layoutPrefixesList();
//	}
//	public void layoutPrefixesList () {
//		this.c.gridy = 9;
//		this.c.gridwidth = 3;
//		this.c.gridheight = 3;
//		
//		this.add(this.prefixes, this.c);
//	}
	
	/**
	 * Updates the text display and the signature display
	 */
	@Override
	public void update (Observable o, Object arg) {
		if (o instanceof Model) {
			//  I love MengShen
			//       ^^^^
			// best comment ever
			this.display.setText(
				this.getModel().getTypedWords()
			  + this.getModel().getCurrentWord()
			  + "|"
			);
			this.signature.setText(this.getModel().getCurrentSignature());
		}
	}
	
}