package computerGraphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graph.SimpleGraph;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DDA extends JFrame {

	private JPanel contentPane;
	private JTextField txtx1;
	private JTextField txty1;
	private JTextField txtx2;
	private JTextField txty2;
	//JPanel DDA_panel = new JPanel();
	private JButton btnDrawLine;
	SimpleGraph DDA_panel = new SimpleGraph();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DDA frame = new DDA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DDA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 702);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DDA_panel.centralize();
		
		DDA_panel.setBounds(10, 10, 925, 645);
		contentPane.add(DDA_panel);
		
		txtx1 = new JTextField();
		txtx1.setBounds(985, 100, 96, 19);
		contentPane.add(txtx1);
		txtx1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("X1");
		lblNewLabel.setBounds(985, 77, 45, 13);
		contentPane.add(lblNewLabel);
		
		txty1 = new JTextField();
		txty1.setColumns(10);
		txty1.setBounds(985, 199, 96, 19);
		contentPane.add(txty1);
		
		JLabel lblY_1 = new JLabel("Y1");
		lblY_1.setBounds(985, 176, 45, 13);
		contentPane.add(lblY_1);
		
		txtx2 = new JTextField();
		txtx2.setColumns(10);
		txtx2.setBounds(985, 293, 96, 19);
		contentPane.add(txtx2);
		
		JLabel lblX = new JLabel("X2");
		lblX.setBounds(985, 270, 45, 13);
		contentPane.add(lblX);
		
		txty2 = new JTextField();
		txty2.setColumns(10);
		txty2.setBounds(985, 391, 96, 19);
		contentPane.add(txty2);
		
		JLabel lblY = new JLabel("Y2");
		lblY.setBounds(985, 368, 45, 13);
		contentPane.add(lblY);
		
		btnDrawLine = new JButton("DRAW LINE");
		btnDrawLine.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					double x1 = Double.parseDouble(txtx1.getText());
					double y1 = Double.parseDouble(txty1.getText());
					double x2 = Double.parseDouble(txtx2.getText());
					double y2 = Double.parseDouble(txty2.getText());
					Graphics g = DDA_panel.getGraphics();
					
					// calling of dda function
						DDA(x1 , y1 , x2 , y2 , g);
			}
				private void DDA(double x1, double y1, double x2, double y2, Graphics g) {
					// TODO Auto-generated method stub
					double run = x2 - x1 ;
					double rise = y2 - y1 ;
					double steps ;
					
					if (Math.abs(rise) > Math.abs(run)) {
						steps = Math.abs(rise);
					}
					else
						steps = Math.abs(run);
					
					double xInc = (double)run/(double)steps ;
					double yInc = (double)rise/(double)steps ;
					
					double x = x1 ;
					double y = y1 ;
					//DDA_panel.addShape(new SimpleGraph.Line(x1, y1, x, y, Color.BLUE));
					x1=x;
					y1=y;
					//g.drawString(".", (int)x, (int)y);
					
					for (int i = 1; i<= steps; i++) {
						x += xInc;
						y += yInc;
						
						DDA_panel.addShape(new SimpleGraph.Line(x1, y1, x, y, Color.BLUE));
						//g.drawString(".", (int)x, (int)y);
						x1=x;
						y1=y;
					}
				}
		});
		btnDrawLine.setBounds(985, 547, 96, 27);
		contentPane.add(btnDrawLine);
	}

}
