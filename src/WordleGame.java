
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;

public class WordleGame implements ActionListener { // implementing the actionlistener interface

	class Harfler extends JPanel { // creating the 5 boxes view

		JLabel harfler[] = new JLabel[5];

		public Harfler() // constructor
		{
			this.setLayout(new GridLayout(1, 5));

			Border blackBorder = BorderFactory.createLineBorder(Color.gray, 1);

			for (int i = 0; i < 5; i++) {
				harfler[i] = new JLabel();
				harfler[i].setOpaque(true);
				harfler[i].setBorder(blackBorder);
				this.add(harfler[i]); // adding 5 little boxes to the same row

			}

		}

		public void clearWordPanel() {
			for (int i = 0; i < 5; i++) {
				harfler[i].setText("");
			}
		}

		public void setText(String charValue, int position, Color color) {
			this.harfler[position].setText(charValue);
			this.harfler[position].setBackground(color);
			// setting the opaque=true helps us see the color
		}
	}

	class UserInput extends JPanel { // getting the user input

		public JTextField userInput;
		public JButton enterButton;

		public UserInput() {
			this.setLayout(new GridLayout(1, 2));
			userInput = new JTextField();
			userInput.setBackground(Color.decode("#717bff"));
			userInput.setForeground(Color.BLACK.darker());
			userInput.setFont(new Font("Serif", Font.BOLD, 12));
			this.add(userInput);
			enterButton = new JButton("Enter");
			enterButton.setFont(new Font("Serif", Font.BOLD, 12));
			enterButton.setBackground(Color.decode("#ffc425"));
			enterButton.setForeground(Color.BLACK.darker());

			this.add(enterButton);
		}

		public JTextField getUserInput() {
			return userInput;
		}

		public JButton getEnterButton() {
			return enterButton;
		}

	}

	class showTime extends JPanel {

		public showTime() {
			this.setLayout(new GridLayout(1, 1));
			ZonedDateTime now = ZonedDateTime.now();
			ZoneId z = ZoneId.of("Europe/Istanbul");
			ZonedDateTime zdt = ZonedDateTime.now(z);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
			String formattedString = now.format(formatter);

			JLabel heading = new JLabel(formattedString);
			heading.setFont(new Font("Serif", Font.BOLD, 21));
			heading.setForeground(Color.pink.darker());

			this.add(heading);
		}

	}

	class keyboard extends JPanel {

		public JButton a;
		public JButton b;
		public JButton c;
		public JButton d;
		public JButton e;
		public JButton f;
		public JButton g;
		public JButton h;
		public JButton i;
		public JButton j;
		public JButton k;
		public JButton l;
		public JButton m;
		public JButton n;
		public JButton o;
		public JButton p;
		public JButton q;
		public JButton r;
		public JButton s;
		public JButton t;
		public JButton u;
		public JButton v;
		public JButton w;
		public JButton x;
		public JButton y;
		public JButton z;

		public keyboard() {
			this.setLayout(new GridLayout(2, 13));
			a = new JButton("A");
			a.setFont(new Font("Serif", Font.BOLD, 12));
			a.setBackground(Color.decode("#ffc425"));
			a.setForeground(Color.BLACK.darker());
			a.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "A");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(a);
			b = new JButton("B");
			b.setFont(new Font("Serif", Font.BOLD, 12));
			b.setBackground(Color.decode("#ffc425"));
			b.setForeground(Color.BLACK.darker());
			b.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "B");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(b);
			c = new JButton("C");
			c.setFont(new Font("Serif", Font.BOLD, 12));
			c.setBackground(Color.decode("#ffc425"));
			c.setForeground(Color.BLACK.darker());
			c.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "C");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(c);
			d = new JButton("D");
			d.setFont(new Font("Serif", Font.BOLD, 12));
			d.setBackground(Color.decode("#ffc425"));
			d.setForeground(Color.BLACK.darker());
			d.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "D");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(d);
			e = new JButton("E");
			e.setFont(new Font("Serif", Font.BOLD, 12));
			e.setBackground(Color.decode("#ffc425"));
			e.setForeground(Color.BLACK.darker());
			e.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "E");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(e);
			f = new JButton("F");
			f.setFont(new Font("Serif", Font.BOLD, 12));
			f.setBackground(Color.decode("#ffc425"));
			f.setForeground(Color.BLACK.darker());
			f.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "F");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(f);
			g = new JButton("G");
			g.setFont(new Font("Serif", Font.BOLD, 12));
			g.setBackground(Color.decode("#ffc425"));
			g.setForeground(Color.BLACK.darker());
			g.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "G");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(g);
			h = new JButton("H");
			h.setFont(new Font("Serif", Font.BOLD, 12));
			h.setBackground(Color.decode("#ffc425"));
			h.setForeground(Color.BLACK.darker());
			h.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "H");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(h);
			i = new JButton("I");
			i.setFont(new Font("Serif", Font.BOLD, 12));
			i.setBackground(Color.decode("#ffc425"));
			i.setForeground(Color.BLACK.darker());
			i.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "I");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(i);
			j = new JButton("J");
			j.setFont(new Font("Serif", Font.BOLD, 12));
			j.setBackground(Color.decode("#ffc425"));
			j.setForeground(Color.BLACK.darker());
			j.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "J");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(j);
			k = new JButton("K");
			k.setFont(new Font("Serif", Font.BOLD, 12));
			k.setBackground(Color.decode("#ffc425"));
			k.setForeground(Color.BLACK.darker());
			k.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "K");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(k);
			l = new JButton("L");
			l.setFont(new Font("Serif", Font.BOLD, 12));
			l.setBackground(Color.decode("#ffc425"));
			l.setForeground(Color.BLACK.darker());
			l.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "L");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(l);
			m = new JButton("M");
			m.setFont(new Font("Serif", Font.BOLD, 12));
			m.setBackground(Color.decode("#ffc425"));
			m.setForeground(Color.BLACK.darker());
			m.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "M");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(m);
			n = new JButton("N");
			n.setFont(new Font("Serif", Font.BOLD, 12));
			n.setBackground(Color.decode("#ffc425"));
			n.setForeground(Color.BLACK.darker());
			n.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "N");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(n);
			o = new JButton("O");
			o.setFont(new Font("Serif", Font.BOLD, 12));
			o.setBackground(Color.decode("#ffc425"));
			o.setForeground(Color.BLACK.darker());
			o.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "O");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(o);
			p = new JButton("P");
			p.setFont(new Font("Serif", Font.BOLD, 12));
			p.setBackground(Color.decode("#ffc425"));
			p.setForeground(Color.BLACK.darker());
			p.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "P");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(p);
			q = new JButton("Q");
			q.setFont(new Font("Serif", Font.BOLD, 12));
			q.setBackground(Color.decode("#ffc425"));
			q.setForeground(Color.BLACK.darker());
			q.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "Q");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(q);
			r = new JButton("R");
			r.setFont(new Font("Serif", Font.BOLD, 12));
			r.setBackground(Color.decode("#ffc425"));
			r.setForeground(Color.BLACK.darker());
			r.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "R");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(r);
			s = new JButton("S");
			s.setFont(new Font("Serif", Font.BOLD, 12));
			s.setBackground(Color.decode("#ffc425"));
			s.setForeground(Color.BLACK.darker());
			s.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "S");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(s);
			t = new JButton("T");
			t.setFont(new Font("Serif", Font.BOLD, 12));
			t.setBackground(Color.decode("#ffc425"));
			t.setForeground(Color.BLACK.darker());
			t.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "T");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(t);
			u = new JButton("U");
			u.setFont(new Font("Serif", Font.BOLD, 12));
			u.setBackground(Color.decode("#ffc425"));
			u.setForeground(Color.BLACK.darker());
			u.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "U");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(u);
			v = new JButton("V");
			v.setFont(new Font("Serif", Font.BOLD, 12));
			v.setBackground(Color.decode("#ffc425"));
			v.setForeground(Color.BLACK.darker());
			v.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "V");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(v);
			w = new JButton("W");
			w.setFont(new Font("Serif", Font.BOLD, 12));
			w.setBackground(Color.decode("#ffc425"));
			w.setForeground(Color.BLACK.darker());
			w.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "W");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(w);
			x = new JButton("X");
			x.setFont(new Font("Serif", Font.BOLD, 12));
			x.setBackground(Color.decode("#ffc425"));
			x.setForeground(Color.BLACK.darker());
			x.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "X");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(x);
			y = new JButton("Y");
			y.setFont(new Font("Serif", Font.BOLD, 12));
			y.setBackground(Color.decode("#ffc425"));
			y.setForeground(Color.BLACK.darker());
			y.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "Y");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(y);
			z = new JButton("Z");
			z.setFont(new Font("Serif", Font.BOLD, 12));
			z.setBackground(Color.decode("#ffc425"));
			z.setForeground(Color.BLACK.darker());
			z.addMouseListener(new MouseInputListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					userPanel.getUserInput().setText(userPanel.getUserInput().getText() + "Z");
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});
			this.add(z);
		}

		public JButton getButtonA() {
			return a;
		}

		public JButton getButtonB() {
			return b;
		}

		public JButton getButtonC() {
			return c;
		}

		public JButton getButtonD() {
			return d;
		}

		public JButton getButtonE() {
			return e;
		}

		public JButton getButtonF() {
			return f;
		}

		public JButton getButtonG() {
			return g;
		}

		public JButton getButtonH() {
			return h;
		}

		public JButton getButtonI() {
			return i;
		}

		public JButton getButtonJ() {
			return j;
		}

		public JButton getButtonK() {
			return k;
		}

		public JButton getButtonL() {
			return l;
		}

		public JButton getButtonM() {
			return m;
		}

		public JButton getButtonN() {
			return n;
		}

		public JButton getButtonO() {
			return o;
		}

		public JButton getButtonP() {
			return p;
		}

		public JButton getButtonQ() {
			return q;
		}

		public JButton getButtonR() {
			return r;
		}

		public JButton getButtonS() {
			return s;
		}

		public JButton getButtonT() {
			return t;
		}

		public JButton getButtonU() {
			return u;
		}

		public JButton getButtonV() {
			return v;
		}

		public JButton getButtonW() {
			return w;
		}

		public JButton getButtonX() {
			return x;
		}

		public JButton getButtonY() {
			return y;
		}

		public JButton getButtonZ() {
			return z;
		}

	}

	public JFrame gameFrame;
	public Harfler[] wordPanelArray = new Harfler[5]; // creating 5 wordPanels because user has 5 tries
	public UserInput userPanel;
	public String wordleString;
	public showTime time;
	public keyboard board;
	public int count = 0;
	public int CorrectLetterCount = 0;
	int tries = 0;

	@Override
	public void actionPerformed(ActionEvent e) {

		String userWord = this.userPanel.getUserInput().getText();

		if (userWord.length() == 5) {
			playWordle(userWord.trim().toUpperCase());
			if (CorrectLetterCount > 4) {
				clearAllPanels();

				Icon icon = new ImageIcon("fireworks.gif");

				JLabel label = new JLabel(icon);

				//ImageIcon icon2 = new ImageIcon("congrats.png");

				System.out.println(tries);
				String s = Integer.toString(tries);

				JOptionPane.showMessageDialog(gameFrame, "CONGRATS! WANT TO PLAY AGAIN?", "YOU WIN!",
						JOptionPane.INFORMATION_MESSAGE, icon);
				HighScores();
				gameFrame.dispose();
				// f.dispose();
				return;
			}
			count++;
		}
		if (userWord.length() > 5 || userWord.length() < 5) {
			JOptionPane.showMessageDialog(null, "Word should  be 5 letter word, try again", "!",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		// if (count == 6 && CorrectLetterCount <= 4) {
		// JOptionPane.showMessageDialog(null, "You Lost.Better luck next time.",
		// "Oops",
		// JOptionPane.INFORMATION_MESSAGE);
		// gameFrame.dispose();
		// return;

		// }
		if (count == 6 && CorrectLetterCount <= 4) {
			int result = JOptionPane.showConfirmDialog(
					null, "Sure? You want to exit?", "Swing Tester",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				System.out.println("yes");
				tries = 0;
				// clear labels init Harfler etc
			} else if (result == JOptionPane.NO_OPTION) {
				System.out.println("no");
				gameFrame.dispose();
			}

		}
		CorrectLetterCount = 0;

	}

	private void clearAllPanels() {
		for (int i = 0; i <= count; i++) {
			wordPanelArray[i].clearWordPanel();
		}
	}

	public Harfler getActivePanel() {
		return this.wordPanelArray[count];
	}

	public String getWordleString() {
		Path path = Paths.get("Words.txt");

		List<String> wordList = new ArrayList<>();
		try {
			wordList = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random random = new Random();
		int position = random.nextInt(wordList.size());
		return wordList.get(position).trim().toUpperCase();
	}

	private void playWordle(String userWord) {

		List<String> wordleWordsList = Arrays.asList(wordleString.split(""));
		List<String> userWordsList = Arrays.asList(userWord.split(""));

		if (tries <= 4) {
			for (int i = 0; i < 5; i++) {
				if (wordleWordsList.contains(userWordsList.get(i))) {
					if (wordleWordsList.get(i).equals(userWordsList.get(i))) {

						getActivePanel().setText(userWordsList.get(i), i, Color.green);

						CorrectLetterCount++;
					} else {
						getActivePanel().setText(userWordsList.get(i), i, Color.yellow);

					}
				} else {
					getActivePanel().setText(userWordsList.get(i), i, Color.gray);

				}
			}
			tries++;
		}
	}

	public void HighScores() {

		try { // this is for monitoring runtime Exception within the block
			File file = new File("HighScores.txt");
			String textString = Integer.toString(tries);

			// if file doesnt exists, then create it
			if (!file.exists()) { // checks whether the file is Exist or not
				file.createNewFile(); // here if file not exist new file created
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); // creating fileWriter object with the file
			BufferedWriter bw = new BufferedWriter(fw); // creating bufferWriter which is used to write the content into
														// the file
			bw.write(textString + "\r\n");

			// write method is used to write the given content into the file
			bw.close(); // Closes the stream, flushing it first. Once the stream has been closed,
						// further write() or flush() invocations will cause an IOException to be
						// thrown. Closing a previously closed stream has no effect.

		} catch (IOException e) { // if any exception occurs it will catch
			e.printStackTrace();
		}

	}

}
