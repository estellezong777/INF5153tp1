import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Controller {
    private final List<MessageText> listMessageInTransit;
    private final List<Agent> listAgents;
    private final Logger logger;

    public Controller(Logger logger){
        this.listAgents = new ArrayList<>();
        this.listMessageInTransit= new ArrayList<>();
        this.logger=logger;
    }

    // subscribe as an agent while the agent name is unique.
    public void subscribe(Agent agent){
        //check the name if it's already in used
        for (Agent agentName: listAgents){
            if(agentName.equals(agent.getName()) ){
                throw new IllegalArgumentException("Agent name is already subscribed by other! Please chose a new name!");
            };
        }
        // if not, add the agent name to the agents list and print a message to the user
        listAgents.add(agent);
        logger.info("Congratulations! Agent "+agent.getName()+" is subscribed successfully!");

    }

    public void unsubscribe(Agent agent){
        //the user only can unsubscribe while his/her name is in the agent list.
        for (Agent agentName: listAgents){
            if(agentName.equals(agent.getName()) ){
                listAgents.remove(agent);
                logger.info("Agent " + agent.getName() + " unsubscribed successfully!");
        }
        }
        throw new IllegalArgumentException("Agent name doesn't in the agent list! Please check your information!");
    }}
// To do........
