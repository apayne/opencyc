CREATE OR REPLACE TYPE cyclist_type
AS TABLE OF VARCHAR2(4000);
/
----------------------------------------------------------------
-- Create the package specification.
-- Please see the package body and the java stored procedure source for more info.
----------------------------------------------------------------
CREATE OR REPLACE PACKAGE CYC
/***************************************************************************
 *
 * Copyright (C)
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 * yepster@users.sourceforge.net
 *
 * ========================================================================
 *
 * Package body: CYC
 *
 * Interface to java stored procedures that interface with Cyc.
 *
 * @author Yeb Havinga
 *
 * Please note: Oracle is case insensitive.
 *
 ***************************************************************************/
IS
    TYPE cyclist_type_indexed IS TABLE OF VARCHAR2(4000) INDEX BY BINARY_INTEGER; -- for input cyclists

PROCEDURE makeConnection;

PROCEDURE endConnection;

PROCEDURE makeCycConstant( constant_in IN VARCHAR2 );

PROCEDURE assertgaf( gaf_in IN VARCHAR2, mt_in IN VARCHAR2 );

PROCEDURE createMicrotheory(
    mtname_in IN VARCHAR2,
    comment_in IN VARCHAR2,
    isamt_in IN VARCHAR2,
    genlmts_in IN cyclist_type );

FUNCTION assertgaf( gaf_in IN VARCHAR2, mt_in IN VARCHAR2 )
RETURN VARCHAR2;

PROCEDURE assertWithTranscript( sentence_in IN VARCHAR2, mt_in IN VARCHAR2 );

FUNCTION assertWithTranscript( sentence_in IN VARCHAR2, mt_in IN VARCHAR2 )
RETURN VARCHAR2;

FUNCTION isQueryTrue( query_in IN VARCHAR2, mt_in IN VARCHAR2 )
RETURN NUMBER;

FUNCTION askWithVariable( query_in IN VARCHAR2, variable_in IN VARCHAR2, mt_in VARCHAR2 )
RETURN cyclist_type;

FUNCTION getBackChainRules( predicate_in IN VARCHAR2 )
RETURN cyclist_type;

FUNCTION converseList( command_in IN VARCHAR2 )
RETURN cyclist_type;

FUNCTION converseString( command_in IN VARCHAR2 )
RETURN VARCHAR2;

FUNCTION converseObjectToString( command_in IN VARCHAR2 )
RETURN VARCHAR2;

FUNCTION converseEscapedList( command_in IN VARCHAR2 )
RETURN VARCHAR2;

PROCEDURE converseVoid( command_in IN VARCHAR2 );

FUNCTION converseVoid( command_in IN VARCHAR2 )
RETURN cyclist_type;

FUNCTION getKnownConstantByName( name_in IN VARCHAR2 )
RETURN VARCHAR2;


END cyc;
/
QUIT
/
