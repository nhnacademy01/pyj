package clean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

//교수님 수정부분
public class FileDiscountPolicyRepository implements DiscountPolicyRepository {
    Map<String, DiscountPolicy> source = new HashMap<>();

    @Override
    public void insert(DiscountPolicy policy) {
        source.put(policy.getCode(), policy);
        savePolicyToFile(policy);
        File file = new File(policy.getCode());
    }

    private void savePolicyToFile(DiscountPolicy policy) {
        try {
            OutputStream output = new FileOutputStream("C:\\" + policy.getCode() + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public DiscountPolicy findByCode(String code) {
        return readPolicyFromFile(code);
    }

    private DiscountPolicy readPolicyFromFile(String code) {
        try {
            FileReader reader = new FileReader("C:\\" + code + ".txt");
            int cur = 0;
            while ((cur = reader.read()) != -1) {
                System.out.print((char) cur);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Discountable> findByCodes(List<String> codes) {
        return codes.stream()
            .map(this::findByCode)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
}