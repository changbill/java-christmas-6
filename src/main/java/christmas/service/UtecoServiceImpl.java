package christmas.service;

import christmas.repository.UtecoRepository;

public class UtecoServiceImpl implements UtecoService {
    private final UtecoRepository utecoRepository;

    public UtecoServiceImpl(UtecoRepository utecoRepository) {
        this.utecoRepository = utecoRepository;
    }

    public void setDateToVisit(String dateValue) {
        utecoRepository.setDateToVisit(UtecoParser.parseToDate(dateValue));
    }
}
