package core;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

public class GUI extends JPanel {

    private CLIGenerator gen;

    public GUI() {
        try {
            this.gen = new CLIGenerator();
            this.initComponents();
            this.frame.setVisible(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.displayError();
        }
    }

    private void executeCommand() throws IOException {
        this.gen.setAutoLogin(this.autoLoginCheckBox.isSelected());
        this.gen.setLowCPU(this.useLowCPUCheckBox.isSelected());

        this.gen.setOSBotLogin(this.osbotUserTextField.getText(), this.osbotPassTextField.getText());
        this.gen.setBotLogin(this.botUserTextField.getText(), this.botPassTextField.getText(), this.botPinTextField.getText());
        this.gen.setProxy(this.proxyIPTextField.getText(), this.proxyPortTextField.getText(), this.proxyUserTextField.getText(), this.proxyPassTextField.getText());
        this.gen.setScript(this.scriptNameTextField.getText(), this.scriptArgsTextField.getText());

        this.gen.setMemoryAmount((int) this.memSpinner.getValue());
        this.gen.setWorld((int) this.worldSpinner.getValue());

        System.out.println(this.gen.getCommand());
        Runtime.getRuntime().exec(this.gen.getCommand());
    }

    private void executeButtonPressed(ActionEvent e) {
        try {
            this.executeCommand();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void displayError() {
        JFrame errorFrame = new JFrame("OSBot not found.");
        errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        errorFrame.getContentPane().setLayout(null);
        errorFrame.setSize(300, 100);

        JLabel errorLabel = new JLabel("OSBot file was not found...");
        errorFrame.getContentPane().add(errorLabel);
        errorLabel.setBounds(65, 15, 500, 25);

        errorFrame.setLocationRelativeTo(errorFrame.getOwner());
        errorFrame.setVisible(true);
    }

    private void setInstanceVariables() {
        this.frame = new JFrame("CLI");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(Color.BLACK);
        this.frame.setResizable(false);
        this.frame.getContentPane().setLayout(null);

        this.osbotUserTextField = new JTextField();
        this.osbotPassTextField = new JTextField();

        this.proxyIPTextField = new JTextField();
        this.proxyPortTextField = new JTextField();
        this.proxyUserTextField = new JTextField();
        this.proxyPassTextField = new JTextField();

        this.botPassTextField = new JTextField();
        this.botUserTextField = new JTextField();
        this.botPinTextField = new JTextField();

        this.scriptNameTextField = new JTextField();
        this.scriptArgsTextField = new JTextField();

        this.autoLoginCheckBox = new JCheckBox("Use Auto Login Flag");
        this.useLowCPUCheckBox = new JCheckBox("Use Low CPU");

        this.memSpinner = new JSpinner();
        this.worldSpinner = new JSpinner(new SpinnerNumberModel(301, 301, 600, 1));
    }

    private void setOSBotInfo() {

        JLabel osbotInfoLabel = new JLabel("OSBot Info:");
        JLabel osbotLoginLabel = new JLabel("Login:");
        JLabel osbotPasswordLabel = new JLabel("Password:");

        osbotInfoLabel.setForeground(SECTION_LABEL_COLOR);
        this.frame.getContentPane().add(osbotInfoLabel);
        osbotInfoLabel.setBounds(5, 10, 65, 25);

        osbotLoginLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(osbotLoginLabel);
        osbotLoginLabel.setBounds(5, 45, 75, 25);

        osbotPasswordLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(osbotPasswordLabel);
        osbotPasswordLabel.setBounds(5, 85, 80, 25);

        this.osbotUserTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.osbotUserTextField);
        this.osbotUserTextField.setBounds(85, 45, 170, 25);

        this.osbotPassTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.osbotPassTextField);
        this.osbotPassTextField.setBounds(85, 85, 170, 25);
    }

    private void setBotInfo() {
        JLabel botInfoLabel = new JLabel("Bot Info:");
        JLabel botLoginLabel = new JLabel("Login:");
        JLabel botPasswordLabel = new JLabel("Password:");
        JLabel botPinLabel = new JLabel("Pin:");

        botInfoLabel.setForeground(SECTION_LABEL_COLOR);
        this.frame.getContentPane().add(botInfoLabel);
        botInfoLabel.setBounds(5, 135, 85, 25);

        botLoginLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(botLoginLabel);
        botLoginLabel.setBounds(5, 175, 70, 25);

        botPasswordLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(botPasswordLabel);
        botPasswordLabel.setBounds(5, 215, 80, 25);

        botPinLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(botPinLabel);
        botPinLabel.setBounds(5, 255, 80, 25);

        this.botPassTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.botPassTextField);
        this.botPassTextField.setBounds(85, 215, 170, 25);

        this.botUserTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.botUserTextField);
        this.botUserTextField.setBounds(85, 175, 170, 25);

        this.botPinTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.botPinTextField);
        this.botPinTextField.setBounds(85, 255, 170, 25);
    }

    private void setProxyInfo() {

        JLabel proxyInfoLabel = new JLabel("Proxy Info:");
        JLabel proxyIPLabel = new JLabel("IP:");
        JLabel proxyPortLabel = new JLabel("Port:");
        JLabel proxyUserLabel = new JLabel("User:");
        JLabel proxyPassLabel = new JLabel("Pass:");

        proxyInfoLabel.setForeground(SECTION_LABEL_COLOR);
        this.frame.getContentPane().add(proxyInfoLabel);
        proxyInfoLabel.setBounds(5, 305, 155, 25);

        proxyIPLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(proxyIPLabel);
        proxyIPLabel.setBounds(5, 345, 70, 25);

        proxyPortLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(proxyPortLabel);
        proxyPortLabel.setBounds(5, 385, 70, 25);

        proxyUserLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(proxyUserLabel);
        proxyUserLabel.setBounds(5, 425, 70, 25);

        proxyPassLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(proxyPassLabel);
        proxyPassLabel.setBounds(5, 465, 70, 25);

        this.proxyIPTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.proxyIPTextField);
        this.proxyIPTextField.setBounds(85, 345, 170, 25);

        this.proxyPortTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.proxyPortTextField);
        this.proxyPortTextField.setBounds(85, 385, 170, 25);

        this.proxyUserTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.proxyUserTextField);
        this.proxyUserTextField.setBounds(85, 425, 170, 25);

        this.proxyPassTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.proxyPassTextField);
        this.proxyPassTextField.setBounds(85, 465, 170, 25);
    }

    private void setScriptInfo() {
        JLabel scriptInfoLabel = new JLabel("Script Info:");
        JLabel scriptNameLabel = new JLabel("Name:");
        JLabel scriptArgsLabel = new JLabel("Args:");

        scriptInfoLabel.setForeground(SECTION_LABEL_COLOR);
        this.frame.getContentPane().add(scriptInfoLabel);
        scriptInfoLabel.setBounds(5, 510, 155, 25);

        scriptNameLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(scriptNameLabel);
        scriptNameLabel.setBounds(5, 550, 70, 25);

        scriptArgsLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(scriptArgsLabel);
        scriptArgsLabel.setBounds(5, 595, 70, 25);

        this.scriptNameTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.scriptNameTextField);
        this.scriptNameTextField.setBounds(85, 550, 170, 25);

        this.scriptArgsTextField.setBackground(BOX_BACKGROUND);
        this.frame.getContentPane().add(this.scriptArgsTextField);
        this.scriptArgsTextField.setBounds(85, 590, 170, 25);
    }

    private void setMiscInfo() {

        JLabel miscLabel = new JLabel("Misc:");
        JLabel memFlagLabel = new JLabel("-mem:");
        JLabel worldLabel = new JLabel("World:");

        miscLabel.setForeground(SECTION_LABEL_COLOR);
        this.frame.getContentPane().add(miscLabel);
        miscLabel.setBounds(5, 635, 155, 25);

        memFlagLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(memFlagLabel);
        memFlagLabel.setBounds(5, 670, 70, 25);

        worldLabel.setForeground(Color.WHITE);
        this.frame.getContentPane().add(worldLabel);
        worldLabel.setBounds(5, 710, 70, 25);

        this.memSpinner.getEditor().getComponent(0).setBackground(BOX_BACKGROUND);
        this.memSpinner.getEditor().getComponent(0).setForeground(Color.BLACK);
        this.frame.getContentPane().add(this.memSpinner);
        this.memSpinner.setBounds(85, 670, 165, 25);

        this.worldSpinner.getEditor().getComponent(0).setBackground(BOX_BACKGROUND);
        this.worldSpinner.getEditor().getComponent(0).setForeground(Color.BLACK);
        this.frame.getContentPane().add(this.worldSpinner);
        this.worldSpinner.setBounds(85, 705, 165, 25);
    }

    private void setCheckBoxes() {

        this.autoLoginCheckBox.setBackground(Color.BLACK);
        this.autoLoginCheckBox.setForeground(Color.WHITE);
        this.frame.getContentPane().add(this.autoLoginCheckBox);
        this.autoLoginCheckBox.setBounds(85, 5, 145, 25);

        this.useLowCPUCheckBox.setBackground(Color.BLACK);
        this.useLowCPUCheckBox.setForeground(Color.WHITE);
        this.frame.getContentPane().add(this.useLowCPUCheckBox);
        this.useLowCPUCheckBox.setBounds(85, 750, 110, 25);
    }

    private void createButton() {

        JButton executeButton = new JButton("Execute");
        executeButton.setForeground(Color.WHITE);
        executeButton.setBackground(BUTTON_BACKGROUND);
        executeButton.addActionListener(this::executeButtonPressed);
        this.frame.getContentPane().add(executeButton);
        executeButton.setBounds(0, 785, 270, 25);
    }

    private void setSize() {
        Dimension preferredSize = new Dimension();
        for (int i = 0; i < this.frame.getContentPane().getComponentCount(); i++) {
            Rectangle bounds = this.frame.getContentPane().getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }
        Insets insets = this.frame.getContentPane().getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        this.frame.getContentPane().setMinimumSize(preferredSize);
        this.frame.getContentPane().setPreferredSize(preferredSize);
    }

    private void initComponents() {

        this.setInstanceVariables();
        this.setOSBotInfo();
        this.setBotInfo();
        this.setProxyInfo();
        this.setScriptInfo();
        this.setMiscInfo();
        this.setCheckBoxes();
        this.createButton();
        this.setSize();

        this.frame.pack();
        this.frame.setLocationRelativeTo(this.frame.getOwner());
    }

    private final static Color BOX_BACKGROUND = new Color(153, 153, 153);
    private final static Color SECTION_LABEL_COLOR = new Color(204, 0, 204);
    private final static Color BUTTON_BACKGROUND = new Color(255, 51, 51);

    private JFrame frame;
    private JTextField proxyIPTextField;
    private JTextField proxyPortTextField;
    private JTextField proxyUserTextField;
    private JTextField proxyPassTextField;
    private JTextField osbotUserTextField;
    private JTextField osbotPassTextField;
    private JTextField botPassTextField;
    private JTextField botUserTextField;
    private JTextField botPinTextField;
    private JTextField scriptNameTextField;
    private JTextField scriptArgsTextField;
    private JCheckBox autoLoginCheckBox;
    private JCheckBox useLowCPUCheckBox;
    private JSpinner memSpinner;
    private JSpinner worldSpinner;
}
