package staticanalysis;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.ipa.callgraph.AnalysisCacheImpl;
import com.ibm.wala.ipa.callgraph.AnalysisOptions;
import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.ipa.callgraph.CGNode;
import com.ibm.wala.ipa.callgraph.CallGraph;
import com.ibm.wala.ipa.callgraph.CallGraphBuilderCancelException;
import com.ibm.wala.ipa.callgraph.Entrypoint;
import com.ibm.wala.ipa.callgraph.impl.Util;
import com.ibm.wala.ipa.cha.ClassHierarchy;

import utils.StaticAnalysisUtilities;

public class CallGraphAnalysis {

	final static Logger logger = Logger.getLogger(CallGraphAnalysis.class);

	private ClassHierarchy cha;

	private AnalysisScope scope;

	private CallGraph callGraph;

	private Collection<?> entryPointsInterface;

	public CallGraphAnalysis(ClassHierarchy cha, AnalysisScope scope, Collection<?> entryPointsInterface) {
		this.cha = cha;
		this.scope = scope;
		this.entryPointsInterface = entryPointsInterface;
	}

	public void buildCallGraph() {

		Iterable<Entrypoint> entrypoints = StaticAnalysisUtilities.makePublicEntrypoints(this.scope, this.cha,
				this.entryPointsInterface);

		// encapsulates various analysis options: basic interface for options
		// that control call graph generation
		AnalysisOptions options = new AnalysisOptions(this.scope, entrypoints);

		com.ibm.wala.ipa.callgraph.CallGraphBuilder<?> builder = Util.makeRTABuilder(options, new AnalysisCacheImpl(),
				this.cha, this.scope);

		// Basic interface for an object that can build a call graph.
		try {
			callGraph = builder.makeCallGraph(options, null);
		} catch (IllegalArgumentException | CallGraphBuilderCancelException e) {
			logger.error(e);
		}
	}

	public Set<IMethod> forwardAnalysisCallGraph(int steps, List<String> scope, Collection<?> target) {

		logger.debug("Making forward analysis through the CallGraph with: " + steps + " steps");

		Set<IMethod> methods = new LinkedHashSet<IMethod>();

		for (CGNode cgn : this.callGraph) {
			if (target.contains(StaticAnalysisUtilities.getFullClassName(cgn.getMethod()))) {
				logger.debug(cgn.getMethod());
				for (CGNode it : StaticAnalysisUtilities.bfs(this.callGraph, cgn, steps, Arrays.asList("org.argouml"),
						true)) {
					if (!methods.contains(it.getMethod()))
						methods.add(it.getMethod());
				}
			}
		}
		return methods;
	}

	public CallGraph getCallGraph() {
		return callGraph;
	}

	
	public void printPredOfNodes(CGNode cgn) {
		Iterator<CGNode> it = this.callGraph.getPredNodes(cgn);
		
		while(it.hasNext()) {
			CGNode n = it.next();
			logger.debug(cgn.getMethod().getName() + " pred " +  n.getMethod().getName());
		}
	}
	
	public void printSuccOfNodes(CGNode cgn) {
		Iterator<CGNode> it = this.callGraph.getSuccNodes(cgn);
		
		while(it.hasNext()) {
			CGNode n = it.next();
			logger.debug(cgn.getMethod().getName() + " succ " +  n.getMethod().getName());
		}
	}

}