package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Settings;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.SettingsRepository;

import java.util.Optional;

public class SettingsService {

    private SettingsRepository settingsRepository;

    private SettingsService(SettingsRepository settingsRepository){
        this.settingsRepository = settingsRepository;
    }

    private void insertSettings(Settings settings){
        this.settingsRepository.save(settings);
    }

    private Optional<Settings> listSettingsByCompanyId(Long id){

        Optional<Settings> settings = Optional.ofNullable(this.settingsRepository.findByCompanyId(id));

        return  settings;
    }
}
