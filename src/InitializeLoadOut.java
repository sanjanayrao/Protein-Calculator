import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.*;

public class InitializeLoadOut {
  
  protected JButton clearAll = new JButton("<< Clear Text");
  protected JButton foodToProteinBtn = new JButton("Find protein amount");
  protected JButton clearProtein = new JButton("Clear Text >>");
  protected JTextArea foodTextArea;
  protected JTextArea proteinTextArea;
  protected JPanel mainPanel;
  protected JSplitPane splitPane;

  protected InitializeLoadOut() {
    foodTextArea = new JTextArea(7, 7);
    foodTextArea.setText("List what you ate");
    foodTextArea.setLineWrap(true);
    foodTextArea.setWrapStyleWord(true);
    foodTextArea.setMargin(new Insets(5, 5, 5, 5));
    foodTextArea.setFont(new Font("", 0, 30));

    JLabel foodTextLabel = new JLabel("Food");
    foodTextLabel.setHorizontalAlignment(SwingConstants.CENTER);


    JPanel foodControlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    foodControlPanel.add(clearAll);
    foodControlPanel.add(foodToProteinBtn);


    JPanel proteinTextPanel = new JPanel();
    proteinTextPanel.setLayout(new BorderLayout());
    proteinTextPanel.add(foodTextLabel, BorderLayout.NORTH);
    proteinTextPanel.add(new JScrollPane(foodTextArea), BorderLayout.CENTER);
    proteinTextPanel.add(foodControlPanel, BorderLayout.SOUTH);

    proteinTextArea = new JTextArea();
    proteinTextArea.setLineWrap(true);
    proteinTextArea.setWrapStyleWord(true);
    proteinTextArea.setLineWrap(true);
    proteinTextArea.setMargin(new Insets(5, 5, 5, 5));
    proteinTextArea.setFont(new Font("", 0, 60));

    JLabel proteinTextLabel = new JLabel("Amount Protein");
    proteinTextLabel.setHorizontalAlignment(SwingConstants.CENTER);



    JPanel proteinControlPanel = new JPanel();
    proteinControlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    proteinControlPanel.add(clearProtein);

    JPanel proteinTextPanel1 = new JPanel();
    proteinTextPanel1.setLayout(new BorderLayout());
    proteinTextPanel1.add(proteinTextLabel, BorderLayout.NORTH);
    proteinTextPanel1.add(new JScrollPane(proteinTextArea), BorderLayout.CENTER);
    proteinTextPanel1.add(proteinControlPanel, BorderLayout.SOUTH);



    splitPane =
        new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, proteinTextPanel, proteinTextPanel1);
    splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    JTextArea infoTextArea = new JTextArea();
    infoTextArea.setLineWrap(true);

    infoTextArea.setWrapStyleWord(true);
    infoTextArea.setText("PROTEIN TRACKER");
    infoTextArea.setBackground(new Color(241, 241, 241));
    infoTextArea.setEditable(false);
    infoTextArea.setMargin(new Insets(5, 5, 5, 5));


    JPanel infoPanel = new JPanel(new BorderLayout());
    infoPanel.add(infoTextArea, BorderLayout.CENTER);


    mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(infoPanel, BorderLayout.NORTH);
    mainPanel.add(splitPane, BorderLayout.CENTER);
  }
}
