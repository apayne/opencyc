package org.opencyc.elf.wm;

//// Internal Imports
import org.opencyc.elf.bg.planner.Schedule;

import org.opencyc.elf.bg.taskframe.Action;
import org.opencyc.elf.bg.taskframe.TaskFrame;

//// External Imports
import java.util.ArrayList;

/**
 * TaskFrameFactory populates the task frame library.  There is a singleton instance.
 *
 * @version $Id$
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
public class TaskFrameFactory {
  
  //// Constructors
  
  /** Creates a new instance of TaskFrameFactory and stores it in the singleton instance. */
  public TaskFrameFactory() {
    taskFrameFactory = this; 
  }
  
  //// Public Area
  
  /**
   * Gets the task frame factory singleton instance.
   *
   * @return the task frame factory singleton instance
   */
  public TaskFrameFactory getInstance () {
    return taskFrameFactory;
  }
  
  /**
   * Poplulates the task frame library.
   */
  public void populateTaskFrameLibrary () {
    // converse with user
    TaskFrame taskFrame = new TaskFrame();
    Action action = ActionLibrary.getInstance().getAction(Action.CONVERSE_WITH_USER);
    taskFrame.setTaskName(action.getName());
    taskFrame.setTaskAction(action);
    Schedule schedule = new Schedule();
    ArrayList plannedActions = new ArrayList();
    action = ActionLibrary.getInstance().getAction(Action.CONSOLE_PROMPTED_INPUT);
    schedule.setPlannedActions(plannedActions);
    ArrayList resources = new ArrayList();
    ArrayList actuators = new ArrayList();
    taskFrame.addScheduleInfo(schedule, resources, actuators);
    
    
    //TODO actuator pool, sensor pool?
    //taskFrame.setTaskGoal(taskGoal);    
  }
  
  //// Protected Area
  
  //// Private Area
  
  //// Internal Rep
  
  /** the task frame factory singleton instance */
  protected static TaskFrameFactory taskFrameFactory;
  
  //// Main
  
}