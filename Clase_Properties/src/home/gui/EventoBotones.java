package home.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import home.bo.PropiedadesBO;

public class EventoBotones implements ActionListener {

	private JTextArea textarea;
	private JTextField [] campos;
	private PropiedadesBO bo;
	
	public EventoBotones() {
		bo = new PropiedadesBO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) e.getSource();

		switch (btn.getText()) {
		case "Colocar":
			bo.colocar(campos[0].getText(), campos[1].getText());
			listarPropiedades();
			break;
		case "Borrar":
			bo.borrar(campos[0].getText());
			listarPropiedades();
			break;
		case "Obtener":
			campos[1].setText(bo.obtener(campos[0].getText()));
			listarPropiedades();
			break;
		case "Guardar":
			bo.guardar();
			listarPropiedades();
			break;
		case "Cargar":
			bo.cargar();
			listarPropiedades();
			break;
		}
		
		if(!btn.getText().equals("Obtener")) {
			for (int i = 0; i < campos.length; i++) {
				campos[i].setText("");
			}
		}
	}
	
	public void listarPropiedades() {
		textarea.setText(bo.listarPrpiedades().toString());
	}
	
	public void setTextArea(JTextArea textarea) {
		this.textarea = textarea;
	}

	public void setFields(JTextField campos[]) {
		this.campos = campos;
	}
}