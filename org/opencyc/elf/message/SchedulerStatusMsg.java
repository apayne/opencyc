package org.opencyc.elf.message;

//// Internal Imports
import org.opencyc.elf.NodeComponent;

import org.opencyc.elf.Status;

//// External Imports

/** Provides the status message that is sent from the scheduler to the job assigner.
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
public class SchedulerStatusMsg extends GenericMsg {
  
  //// Constructors
  
  /** Creates a new instance of SchedulerStatusMsg. 
   *
   * @param sender the sender of the message
   * @param status the scheduler status
   */
  public SchedulerStatusMsg(NodeComponent sender, Status status) {
    this.sender = sender;
    this.status = status;
  }
  
  //// Public Area
  
  /** Returns a string representation of this object.
   *
   * @return a string representation of this object
   */
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("[SchedulerStatusMsg: ");
    stringBuffer.append(status.toString());
    stringBuffer.append("]");
    return stringBuffer.toString();
  }
  
  /** Gets the scheduler status
   *
   * @return the scheduler status
   */
  public Status getStatus () {
    return status;
  }

  //// Protected Area
  
  //// Private Area
  
  //// Internal Rep
  
  /** the scheduler status */
  protected Status status;
  
  //// Main
  
}
