	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.DefaultListModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	import javax.swing.JList;

	public class CalculadoraIVA extends JFrame implements ActionListener {

		private JLabel mensaje;
		private JButton boton;
		private JTextField caja1;
//		private JTextField caja2;
//		private JList<Integer> lista;
//		private DefaultListModel<Integer> model = new DefaultListModel();
		private String selectIva;
		
		public CalculadoraIVA() {
			super();
			configurarVentana();
			crearComponentes();
		}

		private void configurarVentana(){
			this.setTitle("Hello world");
			this.setSize(300, 200);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
			this.setResizable(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		private void crearComponentes() {
			mensaje = new JLabel();
			mensaje.setText("Cantidad");
			mensaje.setBounds(50, 8, 100, 30);
//			mensaje.setForeground(Color.RED);
			this.add(mensaje);
			
			caja1 = new JTextField();
			caja1.setBounds(50, 30, 100, 30);
			this.add(caja1);
			
			mensaje = new JLabel();
			mensaje.setText("IVA");
			mensaje.setBounds(50, 53, 100, 30);
//			mensaje.setForeground(Color.RED);
			this.add(mensaje);
/*			
			lista = new JList<>( model );
			int ivas[] = {8,16};
			for (int i = 0; i < 2; i++) {
				model.addElement(ivas[i]);
			}
			lista.setBounds(50, 130, 100, 30);
			this.add(lista);
*/
			String[] listaIva = new String[] {"16", "8"};
			JComboBox<String> iva = new JComboBox<>(listaIva);
			iva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectIva = iva.getItemAt(iva.getSelectedIndex());
				}
			});
			iva.setBounds(50, 75, 100, 30);
			this.add(iva);
			
			boton = new JButton();
			boton.setText("Calcular");
			boton.setBounds(50, 115, 100, 30);
			boton.addActionListener(this);
			this.add(boton);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str1 = caja1.getText();
			int cantidad;
			cantidad = Integer.parseInt(str1);
			double iva = Double.parseDouble(selectIva) * 0.01;
			double resultado = cantidad * iva;
			JOptionPane.showMessageDialog(this,  "El IVA tiene un valor de: $" + resultado);
		}
		
		public static void main(String[] args) {
			CalculadoraIVA ventana = new CalculadoraIVA();
			ventana.setVisible(true);
		}
	}
