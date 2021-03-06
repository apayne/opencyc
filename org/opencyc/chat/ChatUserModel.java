package org.opencyc.chat;

import java.util.HashMap;

/**
 * Provides a chat user model.<p>
 *
 * Implemented as a simple property dictionary.
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
public class ChatUserModel {

    /**
     * Indicates that the user model is completely restored from the KB.
     */
    protected boolean isInitialized = false;

    /**
     * Dictionary of attribute and object values.
     */
    protected HashMap attributes = new HashMap();

    /**
     * Constructs a new ChatUserModel object.
     *
     * @param chatUserUniqueId the unique id assigned to the user by the chat
     * system
     */
    public ChatUserModel(String chatUserUniqueId) {
        set("chatUserUniqueId", chatUserUniqueId);
    }

    /**
     * Initializes the user model.
     */
    public void initialize () {

        // TODO restore attributes from the KB
        isInitialized = true;
    }

    /**
     * Sets the value for the given attribute.
     *
     * @param attribute the key object
     * @param value the value object
     */
    public void set (String attribute, Object value) {

        // TODO launch a thread to store the attribute in the KB
        attributes.put(attribute, value);
    }

    /**
     * Returns the value for the given attribute.
     *
     * @param attribute the key object
     * @retrun the value for the given attribute
     */
    public Object get (Object attribute) {
        return attributes.get(attribute);
    }
}