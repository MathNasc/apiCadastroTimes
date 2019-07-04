package com.nascimento.resources;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nascimento.domain.Time;

import com.nascimento.repository.TimeRepository;

import com.nascimento.domain.Time;

@RestController
public class TimeAPI {
	
		@Autowired
		TimeRepository timeRepository;
		
		@RequestMapping(value = "/health", method = RequestMethod.GET)
		@ResponseBody
		public String test() {
			
			return "Sistema Time ativo - " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			
			// classes: SimpleDateFormat e Date
		}
		
		/**
		 * Retorna todos os Times cadastrados
		 * @return
		 */
		@RequestMapping(value = "/times", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<List<Time>> obterTime() {
			
			List<Time> Times; // Classe List -> define um array de objetos da classe Time
			
			Times = timeRepository.findAll();
			if (Times.isEmpty())
				return new ResponseEntity<List<Time>>(Times, HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<List<Time>>(Times, HttpStatus.OK);
			
		}
		
		/**
		 * Obter Time pelo id (chave primaria - PK)
		 * 
		 * @param id
		 * @return
		 */
		@RequestMapping(value = "/times/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> obterTimeId(@PathVariable Integer id) {
			
			Optional<Time> Time; // Optional: container objeto.
			
			Time = timeRepository.findById(id);
			
			if (Time.isPresent())
				return new ResponseEntity<Time>(Time.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Time>(Time.get(), HttpStatus.NO_CONTENT);
		}
		
		/**
		 * Inserir um novo Time
		 * @param Time
		 * @return
		 */
		@RequestMapping(value = "/times", method = RequestMethod.POST)
		public ResponseEntity<Time> inserirTimeId(@RequestBody Time Time) {
							
			timeRepository.save(Time);
			
			return new ResponseEntity<Time>(Time, HttpStatus.CREATED);
		}
		
		/**
		 * Alterar um Time existente
		 * @param Time
		 * @return
		 */
		@RequestMapping(value = "/times/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Time> updateTimeId(@RequestBody Time TimePost, @PathVariable Integer id) {
			
			Optional<Time> TimeRepo; 
			
			TimeRepo = timeRepository.findById(id);
			
			if (!TimeRepo.isPresent())
				return new ResponseEntity<Time>(TimePost, HttpStatus.NO_CONTENT);
			
			if (TimePost.getName() != null)
				TimeRepo.get().setName(TimePost.getName());
			if (TimePost.getColor() != null)
				TimeRepo.get().setColor(TimePost.getColor());
			if (TimePost.getFundation_year() != null)
				TimeRepo.get().setFundation_year(TimePost.getFundation_year());
			if (TimePost.getStadium() != null)
				TimeRepo.get().setStadium(TimePost.getStadium());
			if (TimePost.getCoach() != null)
				TimeRepo.get().setCoach(TimePost.getCoach());
			if (TimePost.getTwisted_organized() != null)
				TimeRepo.get().setTwisted_organized(TimePost.getTwisted_organized());
			if (TimePost.getTeamId() != null)
				TimeRepo.get().setTeamId(TimePost.getTeamId());
							
			timeRepository.save(TimeRepo.get());
			
			return new ResponseEntity<Time>(TimeRepo.get(), HttpStatus.OK);
		}
		
		@RequestMapping(value = "/times/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Time> deleteTimeId(@PathVariable Integer id) {
			
			Optional<Time> TimeRepo; 
			
			TimeRepo = timeRepository.findById(id);
			
			if (!TimeRepo.isPresent())
				return new ResponseEntity<Time>(TimeRepo.get(), HttpStatus.NO_CONTENT);
		
			timeRepository.deleteById(id);
			
			return new ResponseEntity<Time>(TimeRepo.get(), HttpStatus.OK);
		}
		
}