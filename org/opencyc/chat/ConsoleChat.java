package org.opencyc.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.opencyc.api.CycApiException;
import org.opencyc.util.Log;

/**
 * Provides a console chat application using the Cyc ChatterBot.<p>
 *
 * The chat conversation is in the form of a text conversation using
 * asynchronous receiving and sending of messages.
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
public class ConsoleChat implements ChatSender {

    /**
     * reference to ChatterBot
     */
    protected ChatterBot chatterBot;

    /**
     * Constructs a new ConsoleChat object.
     */
    public ConsoleChat() {
        Log.makeLog();
        chatterBot = new ChatterBot(this);
        try {
            chatterBot.initialize();
            chat();
            chatterBot.finalize();
        }
        catch (Exception e) {
            Log.current.errorPrintln(e.getMessage());
            Log.current.printStackTrace(e);
            System.exit(1);
        }
    }

    /**
     * Provides a main function to launch the ConsoleChat application.  The
     * args are not used.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();

    }

    /**
     * Provides a console interface to the ChatterBot.
     */
    protected void chat() throws CycApiException, IOException, ChatException {
        while (true) {
            String userInput = receiveChatMessage();
            chatterBot.receiveChatMessage("console user",
                                          "console user",
                                          userInput);
        }
    }

    /**
     * Receives chat messages from the user.
     */
    protected String receiveChatMessage() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("user> ");
        return stdin.readLine();
    }


    /**
     * Sends the chat message from Cyc into the chat system.
     */
    public void sendChatMessage(String chatMessage) {
        System.out.println("cyc> " + chatMessage);
    }
}
