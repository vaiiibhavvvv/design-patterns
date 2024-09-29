package src.solid;

import java.util.ArrayList;
import java.util.List;

interface Developer {
    void develop();
}

// Frontend developer class implements Developer interface
class FrontendDeveloper implements Developer {
    @Override
    public void develop() {
        System.out.println("Frontend development is writing HTML, CSS, and JavaScript code");
    }
}

// Backend developer class implements Developer interface
class BackendDeveloper implements Developer {
    @Override
    public void develop() {
        System.out.println("Backend developer is writing Java code");
    }
}

// Project class that works with any developer type
class Project {

    private List<Developer> developers; // List of developers

    // Constructor that takes in the list of developers
    public Project(List<Developer> developers) {
        this.developers = developers;
    }

    // Method that tells all developers to work (i.e., develop)
    public void developSoftware() {
        for (Developer developer : developers) {
            developer.develop(); // Call each developer's develop method
        }
    }
}

public class DependencyInversion {
    public static void main(String[] args) {

        // Create a list of developers
        List<Developer> developers = new ArrayList<>();
        developers.add(new FrontendDeveloper()); // Add a frontend developer
        developers.add(new BackendDeveloper());  // Add a backend developer

        // Create a project with the list of developers
        Project project = new Project(developers);

        // Start developing software (both frontend and backend developers will work)
        project.developSoftware();
    }
}
