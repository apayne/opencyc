package org.opencyc.uml.commonbehavior;

import org.opencyc.cycobject.*;
import org.opencyc.uml.interpreter.*;

/**
 * Expression from the UML Common_Behavior package.
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

public class Expression {

    /**
     * the name of the language of this expression
     */
    protected String language;

    /**
     * the body of this expression
     */
    protected Object body;

    /**
     * Constructs a new Expression object.
     */
    public Expression() {
    }

    /**
     * Gets the name of the language of this expression.
     *
     * @return the name of the language of this expression
     */
    public String getLanguage () {
        return language;
    }

    /**
     * Sets the name of the language of this expression.
     *
     * @param language the name of the language of this expression
     */
    public void setLanguage (String language) {
        this.language = language;
    }

    /**
     * Gets the body of this expression.
     *
     * @return the body of this expression
     */
    public Object getBody () {
        return body;
    }

    /**
     * Sets the body of this expression.
     *
     * @param body the body of this expression
     */
    public void setBody (Object body) {
        this.body = body;
    }
}