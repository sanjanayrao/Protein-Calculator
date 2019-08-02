import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public class Tracker {


  private int totalProtein = 0;
  private Foods myFoods = new Foods();


  public Tracker() {
    InitializeLoadOut screen = new InitializeLoadOut();


    screen.clearAll.addActionListener((e) -> {
      screen.foodTextArea.setText(null);
    });

    screen.clearProtein.addActionListener((e) -> {
      screen.proteinTextArea.setText(null);
    });

    screen.foodToProteinBtn.addActionListener((e) -> {
      totalProtein = 0;
      // TODO: update to add status reports (100+ is good, 70-99 = almost there...)
      screen.proteinTextArea.setText(proteinToFood(screen.foodTextArea.getText()) + "g of protein");
    });


    JFrame frame = new JFrame();
    frame.setTitle(
        "Protein Calculator by Sanjana Rao");
    frame.setLayout(new BorderLayout());
    frame.add(screen.mainPanel, BorderLayout.CENTER);
    frame.setSize(new Dimension(900, 600));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);

    screen.splitPane.setDividerLocation(frame.getWidth() / 2);

  }



  private String proteinToFood(String food) {
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
