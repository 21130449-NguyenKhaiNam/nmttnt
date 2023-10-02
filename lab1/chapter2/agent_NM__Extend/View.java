package chapter2.agent_NM__Extend;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter2.agent_NM__Extend.Environment.LocationState;

public class View extends JFrame {
	private Environment environment;
	private Map<String, JButton> mapBtns;
	
	public View(Environment environment) {
		this.environment = environment;
		init();
		initComponents();
		start();
	}

	private void start() {
		// TODO Auto-generated method stub
		this.environment.stepUntilDone();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();

		setLayout(new CardLayout());
		panel.setLayout(new GridLayout(Environment.LOCATIONS.length, Environment.LOCATIONS[0].length, 5, 5));
		mapBtns = new HashMap<String, JButton>();
		String path = "C:\\Users\\AD\\work\\java\\AI\\src\\chapter2\\agent_NM__Extend\\";
		for (int i = 0; i < Environment.LOCATIONS.length; i++) {
			for (int j = 0; j < Environment.LOCATIONS[i].length; j++) {
				JButton btn = null;
				String name = Environment.LOCATIONS[i][j];
				if (environment.getCurrentState().getAgentLocation().equals(name)) {
					btn = new JButton(name, new ImageIcon(path + "nguoi-lao-dong.jpg"));
				} else {
					LocationState state = environment.getCurrentState().getLocationState(name);
					if (state == LocationState.DIRTY) {
						btn = new JButton(name, new ImageIcon(path + "vet-ban.png"));
					} else if (state == LocationState.OBSTACLE) {
						btn = new JButton(name, new ImageIcon(path + "do-choi.png"));
					} else if (state == LocationState.WALL) {
						btn = new JButton(name, new ImageIcon(path + "buc-tuong.png"));
					} else {
						btn = new JButton(name, new ImageIcon());
					}
				}
				mapBtns.put(name, btn);
				panel.add(btn);
			}
		}

		this.environment.setMapBtns(mapBtns);
		add(panel);

		setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		setTitle("Robot stupid");
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static void main(String[] args) {
		Environment env = new Environment();
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATIONS[0][0]);

		new View(env);
	}

}
