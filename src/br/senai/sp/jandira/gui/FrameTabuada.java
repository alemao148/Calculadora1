package br.senai.sp.jandira.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.senai.sp.jandira.model.Cliente;

public class FrameTabuada {

	// atributos da Tela
	public String titulo;
	public int altura;
	public int largura;

	// Criação da tela
	public void criarTela() {

		JFrame tela = new JFrame();
		Font tituloDoPrograma = new Font("", Font.BOLD, 30);
		Font componentesDaConta = new Font("", Font.PLAIN, 20);
		Font buttonEResultado = new Font("", Font.BOLD, 15);
		tela.setIconImage(new ImageIcon("src/images/icone.png").getImage());
		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.getContentPane().setBackground(new Color(245, 245, 245));

		// Criação do container
		Container painel = tela.getContentPane();

		// Criação dos componentes da tela

		URL url = getClass().getResource("/imagem/ImagemTabuada.png");
		ImageIcon icon = new ImageIcon(url);
		JLabel labelAprendendo = new JLabel(icon);
		labelAprendendo.setBounds(-10, -5, 100, 100);
		
		JButton buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		buttonCalcular.setBackground(new Color(1, 107, 12));
		buttonCalcular.setForeground(Color.white);
		buttonCalcular.setFont(buttonEResultado);
		buttonCalcular.setBounds(15, 260, 247, 40);

		JButton buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBackground(new Color(237, 186, 2));
		buttonLimpar.setForeground(Color.white);
		buttonLimpar.setFont(buttonEResultado);
		buttonLimpar.setBounds(270, 260, 200, 40);

		JLabel labelResultado = new JLabel();
		labelResultado.setText("Resultado:");
		labelResultado.setFont(buttonEResultado);
		labelResultado.setBounds(15, 295, 150, 50);

		JLabel labelTituloTabuada = new JLabel();
		labelTituloTabuada.setText("Tabuada");
		labelTituloTabuada.setFont(tituloDoPrograma);
		labelTituloTabuada.setForeground(Color.red);
		labelTituloTabuada.setBounds(75, 5, 150, 50);

		JLabel labelDescricaoTabuada = new JLabel();
		labelDescricaoTabuada.setText("Com a tabuada 1.0 os seus problemas acabaram. Calcule");
		labelDescricaoTabuada.setForeground(new Color(181, 181, 181));
		labelDescricaoTabuada.setBounds(80, 5, 340, 100);

		JLabel labelDescricaoTabuada2 = new JLabel();
		labelDescricaoTabuada2.setText("a tabuada que desejar em segundos!");
		labelDescricaoTabuada2.setForeground(new Color(181, 181, 181));
		labelDescricaoTabuada2.setBounds(80, 17, 340, 100);

		JLabel labelMultiplicando = new JLabel();
		labelMultiplicando.setText("Multiplicando:");
		labelMultiplicando.setFont(componentesDaConta);
		labelMultiplicando.setBounds(130, 100, 150, 50);

		JLabel labelMinimoMultiplicador = new JLabel();
		labelMinimoMultiplicador.setText("Mínimo Multiplicador:");
		labelMinimoMultiplicador.setFont(componentesDaConta);
		labelMinimoMultiplicador.setBounds(60, 150, 300, 50);

		JLabel labelMaximoMultiplicador = new JLabel();
		labelMaximoMultiplicador.setText("Máximo Multiplicador:");
		labelMaximoMultiplicador.setFont(componentesDaConta);
		labelMaximoMultiplicador.setBounds(55, 200, 300, 50);

		JTextField textFieldMultiplicando = new JTextField();
		textFieldMultiplicando.setFont(componentesDaConta);
		textFieldMultiplicando.setHorizontalAlignment(JTextField.RIGHT);
		textFieldMultiplicando.setBounds(270, 113, 200, 30);

		JTextField textFieldMinMulti = new JTextField();
		textFieldMinMulti.setFont(componentesDaConta);
		textFieldMinMulti.setHorizontalAlignment(JTextField.RIGHT);
		textFieldMinMulti.setBounds(270, 163, 200, 30);

		JTextField textFieldMaxMulti = new JTextField();
		textFieldMaxMulti.setFont(componentesDaConta);
		textFieldMaxMulti.setHorizontalAlignment(JTextField.RIGHT);
		textFieldMaxMulti.setBounds(270, 213, 200, 30);

		JScrollPane scrollResultado = new JScrollPane();
		scrollResultado.setBounds(15, 340, 454, 305);
		JList<String> listResultado = new JList<String>();
		listResultado.setBackground(new Color(252, 233, 164));
		listResultado.setMinimumSize(new Dimension(100, 100));

		// Adicionando os componentes ao container e o configurando
		painel.add(labelAprendendo);
		painel.add(labelTituloTabuada);
		painel.add(labelDescricaoTabuada);
		painel.add(labelDescricaoTabuada2);
		painel.add(labelMultiplicando);
		painel.add(labelMinimoMultiplicador);
		painel.add(labelMaximoMultiplicador);
		painel.add(textFieldMultiplicando);
		painel.add(textFieldMinMulti);
		painel.add(textFieldMaxMulti);
		painel.add(buttonCalcular);
		painel.add(buttonLimpar);
		painel.add(labelResultado);
		painel.add(listResultado);
		painel.add(scrollResultado);

		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setVisible(true);

		// Definir um listener para o botão calcular
		// Detectar alguma ação no botão de calcular
		buttonCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (Integer.parseInt(textFieldMinMulti.getText()) <= Integer
							.parseInt(textFieldMaxMulti.getText())) {

						Cliente tabuada = new Cliente();
						tabuada.numeroMultiplicado = Integer.parseInt(textFieldMultiplicando.getText());
						tabuada.minMultiplicador = Integer.parseInt(textFieldMinMulti.getText());
						tabuada.maxMultiplicador = Integer.parseInt(textFieldMaxMulti.getText());

						DefaultListModel<String> listModel = new DefaultListModel<String>();
						for (String percorrer : tabuada.getResultados()) {
							listModel.addElement(percorrer);
						}
						listResultado.setModel(listModel);
						scrollResultado.getViewport().add(listResultado);

					} else {
						JOptionPane.showMessageDialog(null,
								"O Mínimo Multiplicador é maior que o Máximo Multiplicador!", "ERRO",
								JOptionPane.ERROR_MESSAGE, null);
						textFieldMultiplicando.setText("");
						textFieldMinMulti.setText("");
						textFieldMaxMulti.setText("");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Não pode inserir um carácter", "ERRO!",
							JOptionPane.ERROR_MESSAGE, null);
					textFieldMultiplicando.setText("");
					textFieldMinMulti.setText("");
					textFieldMaxMulti.setText("");
				}

			}
		});

		buttonLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textFieldMultiplicando.setText("");
				textFieldMinMulti.setText("");
				textFieldMaxMulti.setText("");

				DefaultListModel<String> listModel = new DefaultListModel<String>();
				listResultado.setModel(listModel);

			}

		});

	}

}