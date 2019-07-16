import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class Tracker {


  private static HashMap<String, Integer> myFoods = new HashMap<String, Integer>();
  private int totalProtein = 0;

  public static void KnownFoods() {
    myFoods.put("tofu", 20);
    myFoods.put("almonds", 8);
    myFoods.put("brown rice", 5);
    myFoods.put("peanut butter granola", 10);
    myFoods.put("protein bar", 20);
    myFoods.put("soy milk", 9);
    myFoods.put("protein shake", 36);
    myFoods.put("peanut butter", 9);
    myFoods.put("egg", 7);
    myFoods.put("brown rice", 5);
    myFoods.put("lentils", 13);
    myFoods.put("split pea soup", 14);
    myFoods.put("potato", 4);
  }

  public Tracker() {
    KnownFoods();
    JTextArea foodTextArea = new JTextArea(7, 7);
    foodTextArea.setText("List what you ate");
    foodTextArea.setLineWrap(true);
    foodTextArea.setWrapStyleWord(true);
    foodTextArea.setMargin(new Insets(5, 5, 5, 5));
    foodTextArea.setFont(new Font("", 0, 30));

    JLabel foodTextLabel = new JLabel("Food");
    foodTextLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JButton clearAll = new JButton("<< Clear Text");
    JButton foodToProteinBtn = new JButton("Find protein amount");

    JPanel foodControlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    foodControlPanel.add(clearAll);
    foodControlPanel.add(foodToProteinBtn);


    JPanel proteinTextPanel = new JPanel();
    proteinTextPanel.setLayout(new BorderLayout());
    proteinTextPanel.add(foodTextLabel, BorderLayout.NORTH);
    proteinTextPanel.add(new JScrollPane(foodTextArea), BorderLayout.CENTER);
    proteinTextPanel.add(foodControlPanel, BorderLayout.SOUTH);

    JTextArea proteinTextArea = new JTextArea();
    proteinTextArea.setLineWrap(true);
    proteinTextArea.setWrapStyleWord(true);
    proteinTextArea.setLineWrap(true);
    proteinTextArea.setMargin(new Insets(5, 5, 5, 5));
    proteinTextArea.setFont(new Font("", 0, 60));

    JLabel proteinTextLabel = new JLabel("Amt Protein");
    proteinTextLabel.setHorizontalAlignment(SwingConstants.CENTER);


    JButton clearProtein = new JButton("Clear Text >>");

    JPanel proteinControlPanel = new JPanel();
    proteinControlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    proteinControlPanel.add(clearProtein);

    JPanel proteinTextPanel1 = new JPanel();
    proteinTextPanel1.setLayout(new BorderLayout());
    proteinTextPanel1.add(proteinTextLabel, BorderLayout.NORTH);
    proteinTextPanel1.add(new JScrollPane(proteinTextArea), BorderLayout.CENTER);
    proteinTextPanel1.add(proteinControlPanel, BorderLayout.SOUTH);



    JSplitPane splitPane =
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


    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(infoPanel, BorderLayout.NORTH);
    mainPanel.add(splitPane, BorderLayout.CENTER);



    clearAll.addActionListener((e) -> {
      foodTextArea.setText(null);
    });

    clearProtein.addActionListener((e) -> {
      proteinTextArea.setText(null);
    });

    foodToProteinBtn.addActionListener((e) -> {
      totalProtein = 0;
      // TODO: update to add status reports (100+ is good, 70-99 = almost there...)
      proteinTextArea.setText(proteinToFood(foodTextArea.getText()) + "g of protein");
    });


    JFrame frame = new JFrame();
    frame.setTitle(
        "Protein Tracker by Sanjana Rao - based on Morse Translator by Seun Matt (@SeunMatt2)");
    frame.setLayout(new BorderLayout());
    frame.add(mainPanel, BorderLayout.CENTER);
    frame.setSize(new Dimension(900, 600));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);

    splitPane.setDividerLocation(frame.getWidth() / 2);

  }



  public String proteinToFood(String food) {
    Stream.of(food.split("[\n]")).forEach(s -> {
      if (myFoods.containsKey(s)) {
        totalProtein += myFoods.get(s);
      }
    });
    return "" + totalProtein;
  }



  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }

    SwingUtilities.invokeLater(() -> {
      new Tracker();
    });
  }

}
