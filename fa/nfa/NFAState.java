package fa.nfa;

import fa.State;
import fa.dfa.DFAState;

import java.util.*;

public class NFAState extends State {

    private final char epsilon = 'e';
    private HashMap<Character, Set<NFAState>> transitionMap; // order does not matter here so use HashSet
    private boolean isFinal;//remembers its type

    public NFAState(String name) {
        this.name = name;
        this.isFinal = false;
        transitionMap = new HashMap<Character, Set<NFAState>>();
    }

    /**
     * Accessor for the state type
     * @return true if final and false otherwise
     */
    public boolean isFinal(){
        return isFinal;
    }

    /** Call to make state a final state */
    public void setFinal() {
        this.isFinal = true;
    }


    /**
     * Add the transition from <code> this </code> object
     * @param onSymb the alphabet symbol
     * @param toState to DFA state
     */
    public void addTransition(char onSymb, NFAState toState) {
        Set<NFAState> currentStates = transitionMap.get(onSymb);
        if (currentStates != null) {
            currentStates.add(toState);
        } else {
            // this handles new symbols
            currentStates = new LinkedHashSet<NFAState>();
            currentStates.add(toState);
        }

        transitionMap.put(onSymb, currentStates); // replaces previous set
    }

    /**
     * Retrieves the set of states that this NFAState transitions to
     * on the given symbol returns an empty set for no transitions.
     * @param symb - the alphabet symbol
     * @return the new state
     */
    public Set<NFAState> getTo(char symb){
        Set<NFAState> set = transitionMap.get(symb);
        if(set == null){
            set = new LinkedHashSet<NFAState>();
        }
        return set;
    }


    /**
     * This returns this states reachable states via epsilon transitions
     * @return the set of epsilon states
     */
    public Set<NFAState> getEpsilonStates() {

        return transitionMap.get(epsilon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NFAState)) return false;
        NFAState nfaState = (NFAState) o;
        return this.name.equals(nfaState.name);
    }

    /**
     *  Returns the dfa name with []s
     * @return String dfaName
     */
    public String getDFAName() {
        return "[" + this.getName() + "]";
    }
}
