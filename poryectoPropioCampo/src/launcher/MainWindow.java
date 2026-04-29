package launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import icons.ICONS;

public class MainWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow() {
		super("Aplicación de gestión de deportes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Definimos el tamaño fijo nosotros mismos
		initGUI();
	}

	private void initGUI() {
		
		ImageIcon img = new ImageIcon(ICONS.class.getResource("fondo.jpeg"));
		Image imagen = img.getImage();
		
		//clase anidada que representa el fondo
		//como los JPanel pintan por defecto un fondo blanco, cambiamos su comportamiento, pintando la imagen
		//por tanto, necesitamos una clase que herede de JPanel y modifique dicho comportamiento
		class PanelFondo extends JPanel {
		    
		    private Image imagen;
		    
		    public PanelFondo(Image imagen) {
		        super(new BorderLayout(20, 0)); 
		        this.imagen = imagen;
		    }
		    
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		    }
		}
		
		PanelFondo pf = new PanelFondo(imagen);
		setContentPane(pf);
		JLabel titulo = new JLabel("<html><div style='text-align: center;'>GESTIÓN<br>DEPORTIVA</div></html>");
		titulo.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        titulo.setFont(new Font("SansSerif", Font.BOLD, 70));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        pf.add(titulo,BorderLayout.NORTH);
       
        
        //panel de los botones
        JPanel panelCentro = new JPanel(new GridBagLayout());
        panelCentro.setOpaque(false);
        
        
        JPanel panelBotones = new JPanel(new GridLayout(2,3,30,60));
        panelBotones.setPreferredSize(new Dimension(500, 200));
        panelBotones.setOpaque(false);
        
        
        JButton bMantenimiento  = new JButton("Mantenimiento");
        JButton bEntrenador = new JButton("Entrenador");
        JButton bJugador = new JButton("Jugador");
        JButton bEquipo = new JButton("Equipo");
        JButton bCampo = new JButton("Campo");
        JButton bPartido = new JButton("Partido");
        
        
        panelBotones.add(bMantenimiento);
        panelBotones.add(bEntrenador);
        panelBotones.add(bJugador);
        panelBotones.add(bEquipo);
        panelBotones.add(bCampo);
        panelBotones.add(bPartido);
        
        panelCentro.add(panelBotones); // GridBagLayout centra solo, tanto horizontal como verticalmente
        pf.add(panelCentro, BorderLayout.CENTER);
  
        setLocationRelativeTo(null); 
        setVisible(true);
	}
}
