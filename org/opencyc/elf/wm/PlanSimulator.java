package org.opencyc.elf.wm;

//// Internal Imports
import org.opencyc.elf.NodeComponent;

import org.opencyc.elf.bg.planner.Schedule;

import org.opencyc.elf.bg.taskframe.TaskCommand;

import org.opencyc.elf.message.GenericMsg;
import org.opencyc.elf.message.EvaluateScheduleMsg;
import org.opencyc.elf.message.SimulateScheduleMsg;

//// External Imports

import EDU.oswego.cs.dl.util.concurrent.Executor;
import EDU.oswego.cs.dl.util.concurrent.Puttable;
import EDU.oswego.cs.dl.util.concurrent.Takable;
import EDU.oswego.cs.dl.util.concurrent.ThreadedExecutor;

import java.util.ArrayList;

/**
 * Provides the plan simulator for the ELF WorldModel.<br>
 * 
 * @version $Id: SimulatorPredictor.java,v 1.1 2002/11/17 03:08:17 stephenreed
 *          Exp $
 * @author Stephen L. Reed  
 * <p>Copyright 2001 Cycorp, Inc., license is open source GNU LGPL.
 * <p><a href="http://www.opencyc.org/license.txt">the license</a>
 * <p><a href="http://www.opencyc.org">www.opencyc.org</a>
 * <p><a href="http://www.sourceforge.net/projects/opencyc">OpenCyc at SourceForge</a>
 * <p>
 * THIS SOFTWARE AND KNOWLEDGE BASE CONTENT ARE PROVIDED ``AS IS'' AND
 * ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE OPENCYC
 * ORGANIZATION OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE AND KNOWLEDGE
 * BASE CONTENT, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
public class PlanSimulator extends NodeComponent {
  
  //// Constructors
  
  /**
   * Constructs a new PlanSimulator object.
   */
  public PlanSimulator() {
  }

  /** 
   * Creates a new instance of PlanSimulator with the given
   * input and output message channels.
   *
   * @param planSimulationChannel the takable channel from which messages are input
   * @param planEvaluationChannel the puttable channel to which messages are output
   */
  public PlanSimulator (Takable planSimulationChannel,
                        Puttable planEvaluatorChannel) {
    consumer = new Consumer(planSimulationChannel,
                            planEvaluatorChannel,
                            this);
    executor = new ThreadedExecutor();
    try {
      executor.execute(consumer);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
  
  //// Public Area
  
  //// Protected Area
  
  /**
   * Thread which processes the input message channel.
   */
  protected class Consumer implements Runnable {
    
    /**
     * the takable channel from which messages are input
     */
    protected final Takable planSimulationChannel;
    
    /**
     * the puttable channel to which messages are output for the plan evaluator
     */
    protected final Puttable planEvaluatorChannel;
    
    /**
     * the parent node component
     */
    protected NodeComponent nodeComponent;
    
    /**
     * the resources controlled by this node
     */
    protected ArrayList controlledResources;
    
    /**
     * the node's commanded task
     */
    protected TaskCommand taskCommand;
    
    /**
     * the proposed schedule for evaluation
     */
    protected Schedule schedule;
      
    /**
     * Creates a new instance of Consumer.
     *
     * @param planSimulationChannel the takable channel from which messages are input
     * @param planEvaluatorChannel the puttable channel to which messages are output
     * @param nodeComponent the parent node component
     */
    protected Consumer (Takable planSimulationChannel,
                        Puttable planEvaluatorChannel,
                        NodeComponent nodeComponent) { 
      this.planSimulationChannel = planSimulationChannel;
      this.planEvaluatorChannel = planEvaluatorChannel;
      this.nodeComponent = nodeComponent;
    }

    /**
     * Reads messages from the input queue and processes them.
     */
    public void run () {
      try {
        while (true) { 
          processSimulateScheduleMsg((SimulateScheduleMsg) planSimulationChannel.take()); 
        }
      }
      catch (InterruptedException ex) {}
    }
      
    /**
     * Simulates the schedule from an executor and sends the result to the plan evaluator. 
     */
    protected void processSimulateScheduleMsg(SimulateScheduleMsg simulateScheduleMsg) {
      controlledResources =  simulateScheduleMsg.getControlledResources();
      taskCommand =  simulateScheduleMsg.getTaskCommand();
      schedule =  simulateScheduleMsg.getSchedule();
      //TODO
    }
    
    /**
     * Sends the evaluate schedule message to the plan evaluator.
     */
    protected void sendEvaluateScheduleMsg() {
      //TODO
      Object result = null;
      
      EvaluateScheduleMsg evaluateScheduleMsg = new EvaluateScheduleMsg();
      evaluateScheduleMsg.setSender(nodeComponent);
      evaluateScheduleMsg.setControlledResources(controlledResources);
      evaluateScheduleMsg.setTaskCommand(taskCommand);
      evaluateScheduleMsg.setSchedule(schedule);
      sendMsgToRecipient(planEvaluatorChannel, evaluateScheduleMsg);
    }
  }
  
  //// Private Area
  
  //// Internal Rep
  
  /**
   * the thread which processes the input channel of messages
   */
  Consumer consumer;
  
  /**
   * the executor of the consumer thread
   */
  Executor executor;
  
  //// Main
}