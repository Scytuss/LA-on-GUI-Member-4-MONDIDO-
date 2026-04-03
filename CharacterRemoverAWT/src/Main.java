import java.awt.*;
import java.awt.event.*;

public class Main {

    private Frame frame;
    private Label textLabel;
    private Checkbox vowelCheckBox;
    private Checkbox consonantCheckBox;
    private Checkbox numberCheckBox;
    private Button removeButton;
    private Button restoreButton;

    private String originalText = "ABCDEFGHIJKLMNOPQRSTUVWYZ0123456789";

    public Main() {
        frame = new Frame("Character Remover");

        textLabel = new Label(originalText);
        textLabel.setName("textLabel");

        vowelCheckBox = new Checkbox("Vowels");
        vowelCheckBox.setName("vowelCheckBox");

        consonantCheckBox = new Checkbox("Consonants");
        consonantCheckBox.setName("consonantCheckBox");

        numberCheckBox = new Checkbox("Numbers");
        numberCheckBox.setName("numberCheckBox");

        removeButton = new Button("Remove");
        removeButton.setName("removeButton");

        restoreButton = new Button("Restore");
        restoreButton.setName("restoreButton");

        frame.setLayout(new GridLayout(4, 1));
        textLabel.setAlignment(Label.CENTER);
        frame.add(textLabel);
        Panel checkBoxPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        checkBoxPanel.add(vowelCheckBox);
        checkBoxPanel.add(consonantCheckBox);
        checkBoxPanel.add(numberCheckBox);
        frame.add(checkBoxPanel);
        Panel removePanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        removePanel.add(removeButton);
        frame.add(removePanel);
        Panel restorePanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        restorePanel.add(restoreButton);
        frame.add(restorePanel);

        // --- Button actions ---
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = originalText;

                if (vowelCheckBox.getState()) {
                    result = result.replaceAll("[AEIOUaeiou]", "");
                }
                if (consonantCheckBox.getState()) {
                    result = result.replaceAll("[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]", "");
                }
                if (numberCheckBox.getState()) {
                    result = result.replaceAll("[0-9]", "");
                }

                textLabel.setText(result);
            }
        });

        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText(originalText);
            }
        });

        // --- Window settings ---
        frame.setSize(400, 200);
        frame.setVisible(true);

        // Close window properly
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}