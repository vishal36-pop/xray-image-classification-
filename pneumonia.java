import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class pneumonia {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pneumonia Diagnosis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(765,600);

        frame.setLayout(new BorderLayout(20,10));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel t = new JLabel("image input :");
        JTextField filepath = new JTextField(50);
        filepath.setEditable(false);
        JButton browse = new JButton("browse");
        topPanel.add(t);
        topPanel.add(filepath);
        topPanel.add(browse);
        frame.add(topPanel,BorderLayout.NORTH);
        

        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFileChooser fileChooser = new JFileChooser();
                int response_of_the_user = fileChooser.showOpenDialog(frame);
                if(response_of_the_user==JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();
                    filepath.setText(selectedFile.getAbsolutePath());
                }
            }
        });
        JButton getReport = new JButton("click here to get the result");
        JPanel centPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centPanel.add(getReport);
        frame.add(centPanel);
        
        getReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imagepath = filepath.getText();
                if (imagepath == null || imagepath.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "upload an image 😒");
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(frame,"started evaluating please wait .....");
                }
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder(".venv\\Scripts\\python.exe", "evaluate.py", imagepath);
                    Process process = processBuilder.start();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    StringBuilder output = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        output.append(line).append('\n');
                    }
                    process.waitFor();
                    if (output.length() == 0) {
                        JOptionPane.showMessageDialog(frame, "no output sorry try again 😢");
                    } else {
                        JTextArea textArea = new JTextArea(output.toString().trim());
                        textArea.setWrapStyleWord(true);
                        textArea.setLineWrap(true);
                        textArea.setEditable(false);
                        textArea.setOpaque(false);

                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(450, 250));

                        JOptionPane.showMessageDialog(frame, scrollPane);
                    }
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error running Python: " + ex.getMessage());
                }
            }
        });
        JPanel bottompPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton install_environment = new JButton("install environment ");
        JLabel installwarn = new JLabel("⚠️ Important: If you have not yet installed the required environment, please do so first by clicking :");
        bottompPanel.add(installwarn);
        bottompPanel.add(install_environment);
        frame.add(bottompPanel,BorderLayout.SOUTH);

    install_environment.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                new ProcessBuilder("py", "-m", "venv", ".venv").start().waitFor();


                ProcessBuilder pipInstall = new ProcessBuilder(
                    ".venv\\Scripts\\pip.exe", "install", "-r", "requirements.txt"
                );

                Process process = pipInstall.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder output = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append('\n');
                }
                int exitCode = process.waitFor();

                if (exitCode != 0) {
                    JOptionPane.showMessageDialog(frame, "Installation failed 😢");
                } else {
                    JOptionPane.showMessageDialog(frame, "Virtual environment created and requirements installed!\n\n" + output.toString().trim());
                }

            } catch (IOException | InterruptedException e1) {
                JOptionPane.showMessageDialog(frame, "Error during installation: " + e1.getMessage());
            }
        }
    });

        JPanel bottomPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton activate = new JButton("activate the env");
        bottomPanel1.add(activate);
        frame.add(activate,BorderLayout.EAST);
        
        activate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder(
                        "cmd.exe", "/c",
                        ".venv\\Scripts\\activate.bat && python --version && python -c \"import torch; print(torch.__version__) "
                    );
                    Process process = processBuilder.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    StringBuilder output = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        output.append(line).append('\n');
                    }
                    if (output.length() == 0) {
                        JOptionPane.showMessageDialog(frame, "The environment is NOT activated please install before activating");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Python and torch versions in venv:\n" + output.toString().trim()+"you are all set to go ahead");
            
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Activation failed: " + ex.getMessage());
                }
            }
        });
        frame.setVisible(true);

    }

}
