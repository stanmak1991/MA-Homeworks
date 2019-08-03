package Homework02;

public class Classes {
    public class NestedClass {
        public NestedClass() {
            System.out.println("Nested Class");
        }
    }

    interface InterfaceForAnonymClasses {
        void print();
    };

    InterfaceForAnonymClasses ac = new InterfaceForAnonymClasses() {
        @Override
        public void print() {
            System.out.println("Anonymous Class");
        }
    };

    public void CreateLocalClass() {
        class LocalClass {
            public LocalClass() {
                System.out.println("Local Class");
            }
        }
        LocalClass lc = new LocalClass();
    }
}