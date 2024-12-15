import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class prog1 extends JFrame implements ChangeListener {

    JPanel panel1;
    JComboBox fontBox;
    JSpinner fontSizeSpinner;
    JButton bold;
    JButton italic;
    JButton underline;
    JButton strikeThrough;
    JButton leftAlign;
    JButton centerAlign;
    JButton rightAlign;
    JButton Align;
    JPanel panel2;
    JLabel find;
    JTextField findText;
    JLabel replace;
    JTextField replaceText;
    JPanel panel3;
    JButton findAll;
    JButton findNext;
    JButton replaceB;
    JButton replaceAll;
    JTextArea textArea;
    JPanel outer1;
    JPanel outer01;
    JPanel outer02;
    JPanel panel21;
    JLabel sketch;
    JPanel panel22;
    JButton rect;
    JButton circle;
    JButton line;
    JButton triangle;
    JButton pentagon;
    JButton clear;
    JPanel panel23;
    JTextArea pad;
    JMenuBar menuBar;
    JMenu file;
    JMenuItem open;
    JMenuItem save;
    JMenuItem close;
    JMenu edit;
    JMenuItem undo;
    JMenuItem copy;
    JMenuItem cut;
    JMenuItem paste;
    JMenu view;
    JMenuItem actualSize;
    JMenuItem zoomIn;
    JMenuItem zoomOut;
    JMenu help;
    JMenuItem textEditHelp;
    prog1(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("TextEditor");

        Border blackline = BorderFactory.createLineBorder(Color.black);

        ImageIcon bd = new ImageIcon("bold.png");
        bold = new JButton();
        bold.setIcon(bd);
        ImageIcon it = new ImageIcon("italic.png");
        italic = new JButton();
        italic.setIcon(it);
        ImageIcon ud= new ImageIcon("underlined.png");
        underline = new JButton();
        underline.setIcon(ud);
        ImageIcon st = new ImageIcon("strikethrough.png");
        strikeThrough = new JButton();
        strikeThrough.setIcon(st);
        ImageIcon ca= new ImageIcon("center.png");
        centerAlign = new JButton();
        centerAlign.setIcon(ca);
        ImageIcon la= new ImageIcon("left.png");
        leftAlign = new JButton();
        leftAlign.setIcon(la);
        ImageIcon ra = new ImageIcon("right.png");
        rightAlign = new JButton();
        rightAlign.setIcon(ra);
        ImageIcon justify = new ImageIcon("justification.png");
        Align = new JButton();
        Align.setIcon(justify);

        String [] fonts  = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontBox = new JComboBox(fonts);
        fontBox.setSelectedItem("Arial");

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(this);

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(bold);
        panel1.add(italic);
        panel1.add(underline);
        panel1.add(strikeThrough);
        panel1.add(leftAlign);
        panel1.add(centerAlign);
        panel1.add(rightAlign);
        panel1.add(Align);
        panel1.add(fontBox);
        panel1.add(fontSizeSpinner);

        find = new JLabel("Find");
        findText = new JTextField();
        replace = new JLabel("Replace");
        replaceText = new JTextField();

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4,1));
        panel2.add(find);
        panel2.add(findText);
        panel2.add(replace);
        panel2.add(replaceText);

        findAll = new JButton("Find All");
        findAll.setBackground(new Color(211,227,245,255));
        findAll.setOpaque(true);
        findAll.setBorderPainted(false);
        findNext = new JButton("Find Next");
        findNext.setBackground(new Color(211,227,245,255));
        findNext.setOpaque(true);
        findNext.setBorderPainted(false);
        replaceB = new JButton("Replace");
        replaceB.setBackground(new Color(211,227,245,255));
        replaceB.setOpaque(true);
        replaceB.setBorderPainted(false);
        replaceAll = new JButton("Replace All");
        replaceAll.setBackground(new Color(211,227,245,255));
        replaceAll.setOpaque(true);
        replaceAll.setBorderPainted(false);

        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.add(findAll);
        panel3.add(findNext);
        panel3.add(replaceB);
        panel3.add(replaceAll);

        textArea = new JTextArea();

        outer1 = new JPanel();
        outer1.setLayout(new BorderLayout());
        outer1.add(panel1,BorderLayout.NORTH);
        outer1.add(panel2,BorderLayout.CENTER);
        outer1.add(panel3,BorderLayout.SOUTH);
        outer01 = new JPanel();
        outer01.setLayout(new BorderLayout());
        outer01.setBorder(blackline);
        outer01.add(outer1,BorderLayout.NORTH);
        outer01.add(textArea,BorderLayout.CENTER);

        panel21 = new JPanel();
        sketch = new JLabel("SketchPad");
        panel21.add(sketch,BorderLayout.CENTER);
        panel22 =new JPanel();
        panel22.setLayout(new FlowLayout());

        rect = new JButton("Rectangle");
        rect.setBackground(new Color(211,227,245,255));
        rect.setOpaque(true);
        rect.setBorderPainted(false);
        circle = new JButton("Circle");
        circle.setBackground(new Color(211,227,245,255));
        circle.setOpaque(true);
        circle.setBorderPainted(false);
        line = new JButton("Line");
        line.setBackground(new Color(211,227,245,255));
        line.setOpaque(true);
        line.setBorderPainted(false);
        triangle = new JButton("Triangle");
        triangle.setBackground(new Color(211,227,245,255));
        triangle.setOpaque(true);
        triangle.setBorderPainted(false);
        pentagon = new JButton("Pentagon");
        pentagon.setBackground(new Color(211,227,245,255));
        pentagon.setOpaque(true);
        pentagon.setBorderPainted(false);
        clear = new JButton("Clear");
        clear.setBackground(new Color(211,227,245,255));
        clear.setOpaque(true);
        clear.setBorderPainted(false);

        panel22.add(rect);
        panel22.add(circle);
        panel22.add(line);
        panel22.add(triangle);
        panel22.add(pentagon);
        panel22.add(clear);

        pad = new JTextArea();
        pad.setBackground(Color.darkGray);
        panel23 = new JPanel(new BorderLayout());
        panel23.add(panel21,BorderLayout.NORTH);
        panel23.add(panel22,BorderLayout.SOUTH);

        outer02 = new JPanel();
        outer02.add(panel23,BorderLayout.NORTH);
        outer02.setBorder(blackline);
        outer02.setBackground(Color.gray);

        //Menubar

        menuBar = new JMenuBar();

        file = new JMenu("File");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        close = new JMenuItem("Close");
        file.add(open);
        file.add(save);
        file.add(close);

        edit = new JMenu("Edit");
        undo = new JMenuItem("Undo");
        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        edit.add(undo);
        edit.add(copy);
        edit.add(cut);
        edit.add(paste);

        view = new JMenu("View");
        actualSize = new JMenuItem("Actual Size");
        zoomOut = new JMenuItem("Zoom Out");
        zoomIn = new JMenuItem("Zoom In");
        view.add(actualSize);
        view.add(zoomIn);
        view.add(zoomOut);

        help = new JMenu("Help");
        textEditHelp = new JMenuItem("Text Edit Help");
        help.add(textEditHelp);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);

        //Menubar

        this.setJMenuBar(menuBar);
        this.add(outer01,BorderLayout.CENTER);
        this.add(outer02,BorderLayout.EAST);
        this.setVisible(true);
    }

    public void stateChanged(ChangeEvent e) {
        textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN, (Integer) fontSizeSpinner.getValue()));
    }
    public static void main(String[] args) {
        new prog1();
    }
}