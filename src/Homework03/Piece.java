package Homework03;

public class Piece {
    public void testPiece(String[] roles, String[] textLines) {
        System.out.println(printTextPerRole(roles, textLines));

    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder("");
        StringBuilder[] phrases = new StringBuilder[roles.length];

        for (int textLinesCounter = 0; textLinesCounter < textLines.length; textLinesCounter++) {
            for (int rolesCounter = 0; rolesCounter < roles.length; rolesCounter++) {
                if (phrases[rolesCounter] == null) {
                    phrases[rolesCounter] = new StringBuilder(roles[rolesCounter] + ":\n");
                }
                if(textLines[textLinesCounter].startsWith(roles[rolesCounter], 0)){
                    phrases[rolesCounter].append(textLinesCounter + 1);
                    phrases[rolesCounter].append(")");
                    phrases[rolesCounter].append(textLines[textLinesCounter].substring(roles[rolesCounter].length() + 1));
                    phrases[rolesCounter].append("\n");
                }
            }
        }
        for (int counterOfRolesAndPhrases = 0; counterOfRolesAndPhrases < roles.length; counterOfRolesAndPhrases++) {
            result.append(phrases[counterOfRolesAndPhrases] + "\n");
        }
        return result.toString().trim();
    }
}