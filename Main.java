import java.util.ArrayList;
import java.util.List;

// LEVEL CLASSES

// TOP LEVEL
class DeepLearning {
    List<MainField> mainFields = new ArrayList<>();
}

// LEVEL 1 – Main category
class MainField {
    String name;
    List<SubField> subfields = new ArrayList<>();

    MainField(String name) {
        this.name = name;
    }
}

// LEVEL 2 – Sub categories
class SubField {
    String name;
    SubSubField[] bottomFields;  // ARRAY
    int learningCount;           // for part 1.d

    SubField(String name, SubSubField[] bottomFields) {
        this.name = name;
        this.bottomFields = bottomFields;
    }
}

// LEVEL 3 – Bottom fields (definition + applications)
class SubSubField {
    String name;
    String definition;
    String applications;

    SubSubField(String name, String definition, String applications) {
        this.name = name;
        this.definition = definition;
        this.applications = applications;
    }
}

// DATASET BUILDER

class DatasetBuilder {

    public static DeepLearning buildDataset() {
        DeepLearning dl = new DeepLearning();

        //  MAIN FIELD 1
        MainField nn = new MainField("Neural Network Architectures");

        SubSubField[] cnnBottom = {
                new SubSubField(
                        "Image Classification",
                        "Assigning a label to an image using deep learning.",
                        "Medical imaging, face recognition, security"),
                new SubSubField(
                        "Object Detection",
                        "Detecting objects using learning-based analysis.",
                        "Self-driving cars, robotics, surveillance")
        };

        SubSubField[] rnnBottom = {
                new SubSubField(
                        "Sequence Modeling",
                        "Learning patterns in sequential data.",
                        "Speech recognition, forecasting"),
                new SubSubField(
                        "Language Modeling",
                        "Learning to predict next words.",
                        "Chatbots, translation, NLP")
        };

        nn.subfields.add(new SubField("Convolutional Neural Networks (CNN)", cnnBottom));
        nn.subfields.add(new SubField("Recurrent Neural Networks (RNN)", rnnBottom));
        dl.mainFields.add(nn);

        //  MAIN FIELD 2
        MainField lm = new MainField("Learning Methods");

        SubSubField[] supervisedBottom = {
                new SubSubField(
                        "Classification",
                        "Learning to classify input samples using labeled data.",
                        "Medical diagnosis, image classification"),
                new SubSubField(
                        "Regression",
                        "Learning to predict continuous values.",
                        "Price forecasting, statistics")
        };

        SubSubField[] unsupervisedBottom = {
                new SubSubField(
                        "Clustering",
                        "Grouping samples without labels using learning algorithms.",
                        "Customer segmentation, fraud detection"),
                new SubSubField(
                        "Dimensionality Reduction",
                        "Learning low-dimensional representation.",
                        "Compression, visualization")
        };

        lm.subfields.add(new SubField("Supervised Learning", supervisedBottom));
        lm.subfields.add(new SubField("Unsupervised Learning", unsupervisedBottom));
        dl.mainFields.add(lm);

        // ---------------------- MAIN FIELD 3 ----------------------
        MainField gm = new MainField("Generative Models");

        SubSubField[] ganBottom = {
                new SubSubField(
                        "Image Generation",
                        "Learning to generate synthetic images using adversarial learning.",
                        "Art, deepfakes, design"),
                new SubSubField(
                        "Style Transfer",
                        "Learning artistic transformations of images.",
                        "Photo filters, animation")
        };

        gm.subfields.add(new SubField("GANs (Generative Adversarial Networks)", ganBottom));
        dl.mainFields.add(gm);

        return dl;
    }
}

// MAIN PROGRAM

public class Main {

    // Print dataset for 1.c.3
    public static void printDataset(DeepLearning dl) {
        System.out.println("=== DEEP LEARNING DATASET ===\n");

        for (MainField mf : dl.mainFields) {
            System.out.println("Main Field: " + mf.name);

            for (SubField sf : mf.subfields) {
                System.out.println("  SubField: " + sf.name);

                for (SubSubField b : sf.bottomFields) {
                    System.out.println("    - " + b.name);
                }
            }
            System.out.println();
        }
    }

    // Count all definitions containing “learning”
    public static int countLearning(DeepLearning dl) {
        int count = 0;

        for (MainField mf : dl.mainFields) {
            for (SubField sf : mf.subfields) {
                for (SubSubField b : sf.bottomFields) {
                    if (b.definition.toLowerCase().contains("learning")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Count per subfield and store the result
    public static void countLearningPerSubField(DeepLearning dl) {
        for (MainField mf : dl.mainFields) {
            for (SubField sf : mf.subfields) {
                int cnt = 0;

                for (SubSubField b : sf.bottomFields) {
                    if (b.definition.toLowerCase().contains("learning")) {
                        cnt++;
                    }
                }

                sf.learningCount = cnt; // Save result inside structure
            }
        }
    }

    // Print results for 1.d.2 screenshots
    public static void printLearningResults(DeepLearning dl) {

        System.out.println("=== SEARCH RESULTS ===\n");

        int total = countLearning(dl);
        System.out.println("Total bottom fields containing 'Learning': " + total + "\n");

        countLearningPerSubField(dl);

        for (MainField mf : dl.mainFields) {
            for (SubField sf : mf.subfields) {
                System.out.println(sf.name + " → " + sf.learningCount);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        DeepLearning dl = DatasetBuilder.buildDataset();

        // For 1.c.3 screenshot
        printDataset(dl);

        // For 1.d.2 screenshot
        printLearningResults(dl);
    }
}
