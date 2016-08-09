package home.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameCampos[] = { "Propiedad: ", "Valor: " };
	private String nameBotones[] = { "Colocar", "Borrar", "Obtener", "Guardar", "Cargar" };
	private JLabel labels[] = new JLabel[2];
	private JTextArea textarea;
	private JTextField[] campos = new JTextField[2];
	private JButton[] botones = new JButton[5];

	public GUIPanel() {

		setLayout(new BorderLayout());

		JPanel panelNorth = new JPanel(new FlowLayout());
		for (int i = 0; i < nameCampos.length; i++) {
			labels[i] = new JLabel(nameCampos[i]);
			panelNorth.add(labels[i]);
			campos[i] = new JTextField(10);
			campos[i].setName("propiedad");
			panelNorth.add(campos[i]);
		}

		textarea = new JTextArea(4, 35);
		add(textarea, BorderLayout.CENTER);

		EventoBotones evtbtn = new EventoBotones();
		JPanel panelSouth = new JPanel(new GridLayout(1, 5));
		for (int i = 0; i < nameBotones.length; i++) {
			botones[i] = new JButton(nameBotones[i]);
			panelSouth.add(botones[i]);
			botones[i].addActionListener(evtbtn);
		}
		
		evtbtn.setFields(campos);
		evtbtn.setTextArea(textarea);

		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);

	}

}
