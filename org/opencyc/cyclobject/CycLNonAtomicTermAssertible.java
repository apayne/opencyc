package org.opencyc.cyclobject;

/*****************************************************************************
 * KB comment for #$CycLNonAtomicTerm-Assertible as of 2002/05/07:<p>
 *
 * A #$CycLExpressionType and a specialization of both
 * #$CycLExpression-Assertible and #$CycLNonAtomicTerm (qq.v.).  The collection
 * of all CycL non-atomic terms that could appear within a sentence that could
 * be asserted to the Cyc Knowledge Base.  More precisely, each instance of
 * #$CycLNonAtomicTerm-Assertible is a non-atomic term that is both
 * syntactically and semantically well-formed.  By definition, any CycL
 * non-atomic term is syntactically well-formed.  To be semantically
 * well-formed, a non-atomic term sentence must be constructible via the syntax
 * of CycL without violating any applicable arity or argument-type constraints
 * (see #$arity and #$ArgTypePredicate).  A CycL term must be semantically
 * well-formed in order to be interpretable as having a "semantic value", which
 * for terms means having a denotation.  Note that being "assertible" in the
 * present sense does not require a sentence's actually being asserted in the
 * KB.<p>
 *
 * @version $Id$
 * @author Tony Brusseau, Steve Reed
 *
 * <p>Copyright 2001 Cycorp, Inc., license is open source GNU LGPL.
 * <p><a href="http://www.opencyc.org/license.txt">the license</a>
 * <p><a href="http://www.opencyc.org">www.opencyc.org</a>
 * <p><a href="http://sf.net/projects/opencyc">OpenCyc at SourceForge</a>
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
 *****************************************************************************/
public interface CycLNonAtomicTermAssertible 
  extends CycLNonAtomicTermAskable, CycLExpressionAssertible {
}
