package kr.co.groovy.facility;

import kr.co.groovy.enums.Hipass;
import kr.co.groovy.vo.VehicleVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacilityService {
    private final FacilityMapper mapper;

    public List<VehicleVO> getVehicles() {
        List<VehicleVO> vehicles = mapper.getVehicles();
        for (VehicleVO vehicleVO : vehicles) {
            vehicleVO.setCommonCodeHipassAsnAt(Hipass.valueOf(vehicleVO.getCommonCodeHipassAsnAt()).getLabel());
        }
        return vehicles;
    }

    public List<VehicleVO> getReservedVehicle(String vhcleNo) {
        return mapper.getReservedVehicleByVhcleNo(vhcleNo);
    }

    public List<VehicleVO> getReservedVehicleByEmplId(String vhcleResveEmplId) {
        return mapper.getReservedVehicleByEmplId(vhcleResveEmplId);
    }

    public int inputReservation(VehicleVO vehicleVO) {
        return mapper.inputVehicleReservation(vehicleVO);
    }

    public int deleteReservedByVhcleResveNo(int vhcleResveNo) {
        return mapper.deleteReservedByVhcleResveNo(vhcleResveNo);
    }
}
