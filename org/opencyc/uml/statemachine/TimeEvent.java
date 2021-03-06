package org.opencyc.uml.statemachine;

import org.opencyc.uml.commonbehavior.*;

/**
 * TimeEvent from the UML State_Machine package.
 *
 * @version $Id$
 * @author Stephen L. Reed
 *
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

public class TimeEvent extends Event {

    /**
     * the time expression for this time event
     */
    protected TimeExpression when;

    /**
     * Constructs a new TimeEvent object.
     */
    public TimeEvent() {
    }

    /**
     * Returns true if the given object equals this object.
     *
     * @param object the given object
     * @return true if the given object equals this object, otherwise returns false
     */
    public boolean equals (Object object) {
        return object instanceof TimeEvent;
    }

    /**
     * Gets the time expression for this time event
     *
     * @return the time expression for this time event
     */
    public TimeExpression getWhen () {
        return when;
    }

    /**
     * Sets the time expression for this time event
     *
     * @param when the time expression for this time event
     */
    public void setWhen (TimeExpression when) {
        this.when = when;
    }
}