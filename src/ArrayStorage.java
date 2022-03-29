/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        Resume nF = new Resume();
        nF.uuid = "Not Found";
        return nF;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (get(uuid).uuid.equals(storage[i].uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size - 1);
            }
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resultArr = new Resume[size];
        System.arraycopy(storage, 0, resultArr, 0, size);
        return resultArr;
    }

    int size() {
        return size;
    }
}
